package com.alsalam.sclzroot;

import android.app.Notification;
import android.content.Context;
import android.util.Log;

import com.example.sclzservice.ToDoActivity;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;
import com.microsoft.windowsazure.notifications.NotificationsHandler;

/**
 * Created by Wael on 24/03/16.
 */
public class BackendPushNotifHandler extends NotificationsHandler {
    @Override
    public void onRegistered(Context context, String gcmRegistrationId)
    {
        super.onRegistered(context, gcmRegistrationId);

        // + Support push notifications to users...
        MobileServiceClient client = new ToDoActivity().getmClient();
        MobileServiceTable<Channel> registrations = client.getTable(Channel.class);

        // Create a new Registration
        Channel channel = new Channel();
        channel.setHandle(gcmRegistrationId);

        // Insert the new Registration
        registrations.insert(channel, new TableOperationCallback<Channel>() {

        public void onCompleted(Channel entity, Exception exception, ServiceFilterResponse response) {

            if (exception != null) {
                Log.e("PushHandler", exception.getMessage());
            } else {
                Log.i("PushHandler", "Registration OK");
            }
        }
    });
    }
}
