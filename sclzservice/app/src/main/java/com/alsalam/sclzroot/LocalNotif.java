package com.alsalam.sclzroot;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.alsalam.sclzroot.Activities.MainHomeActivity;
import com.example.sclzservice.R;

/**
 * Created by Wael on 24/03/16.
 */
public class LocalNotif {

    public static int NOTIFICATION_ID = 1;
    private NotificationManager mNotificationManager;
    android.support.v4.app.NotificationCompat.Builder builder;
    Context ctx;

    public void sendNotification(String msg, Context ctx) {
        mNotificationManager = (NotificationManager)
                ctx.getSystemService(Context.NOTIFICATION_SERVICE);


        // TODO
        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
                new Intent(ctx, MainHomeActivity.class), 0);
        Bitmap icon = BitmapFactory.decodeResource(ctx.getResources(),
                R.mipmap.logo);
        android.support.v4.app.NotificationCompat.Builder mBuilder =
                new android.support.v4.app.NotificationCompat.Builder(ctx)
                        .setSmallIcon(R.mipmap.logo)
                        .setContentTitle("Socialize")
                        .setLargeIcon(icon)
                        .setStyle(new android.support.v4.app.NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setContentText(msg);



        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
        NOTIFICATION_ID++;
        Log.d("PushNotif", "Sent:" + msg);
        Log.d("PushNotif", "NOTIF_ID:" + NOTIFICATION_ID);
    }


}
