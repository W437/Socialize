package com.alsalam.sclzroot;

import com.example.sclzservice.R;
import com.example.sclzservice.ToDoActivity;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.notifications.NotificationsHandler;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.net.MalformedURLException;


/**
 * Created by Wael on 15/03/16.
 */
public class PushNotifHandler extends NotificationsHandler {

    public static int NOTIFICATION_ID = 1;
    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;
    Context ctx;
    MobileServiceClient mClient;
    @Override
    public void onRegistered(Context context,  final String gcmRegistrationId) {

        // Mobile Service URL and key
        try {
            mClient = new MobileServiceClient(
                    "https://sclzservice.azurewebsites.net",
                    context);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        super.onRegistered(context, gcmRegistrationId);

        new AsyncTask<Void, Void, Void>() {

            protected Void doInBackground(Void... params) {
                try {
                    mClient.getPush().register(gcmRegistrationId, null);
                    return null;
                }
                catch(Exception e) {
                    // handle error
                }
                return null;
            }
        }.execute();
    }

    @Override
    public void onReceive(Context context, Bundle bundle) {
        ctx = context;
        String nhMessage = bundle.getString("message");
        Log.d("PushNotif", "Received:" + nhMessage);
        sendNotification(nhMessage);
    }

    private void sendNotification(String msg) {
        mNotificationManager = (NotificationManager)
                ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
                new Intent(ctx, ToDoActivity.class), 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(ctx)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Socialize")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
        NOTIFICATION_ID++;
        Log.d("PushNotif", "Sent:" + msg);
        Log.d("PushNotif", "NOTIF_ID:" + NOTIFICATION_ID);
    }

}
