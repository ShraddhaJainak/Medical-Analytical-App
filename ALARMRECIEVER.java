package com.example.lore;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION_CODES;

import androidx.core.app.NotificationCompat;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.*;

public class ALARMRECIEVER extends BroadcastReceiver {


    private static final String CHANNEL_ID = "SAMPLE_CHANNEL";

    @Override
    public void onReceive(Context context, Intent intent) {

        //Get id and message from intent.
        int notificationId = intent.getIntExtra("notificationId",0);
        String message = intent.getStringExtra("Medicine");

        //Call MainActivity when notificarion is tapped
        Intent mainIntent = new Intent(context,MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0 ,mainIntent,0);

        //NotificationManager

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (SDK_INT >= O) {

            //for api 26 and above
            CharSequence channel_name = "My Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = null;
            if (SDK_INT >= O) {
                channel = new NotificationChannel(CHANNEL_ID,channel_name,importance);
            }
            if (SDK_INT >= O) {
                notificationManager.createNotificationChannel(channel);
            }
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle("MEDICINE TIME").setContentIntent(contentIntent).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true);
        //Notify
        notificationManager.notify(notificationId, builder.build());
    }
}

