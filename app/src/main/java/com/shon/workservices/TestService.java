package com.shon.workservices;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.shon.services.BaseServices;
import com.shon.services.annotation.Works;

@Works({TestWork1.class, TestWork2.class})
public class TestService extends BaseServices<TestService> {

    private static final String CHANNEL_ID = "TestService";
    @Override
    public int createNotification(Intent intent, int flags, int startId) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager)getApplication().getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel;
            channel = new NotificationChannel(CHANNEL_ID, "Your App Service", NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(false);//设置提示灯
            channel.setShowBadge(true);//显示logo
            channel.setDescription("Your App Service Description");//设置描述
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC); //设置锁屏可见
            manager.createNotificationChannel(channel);
            Notification notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("Title")//标题
                    .setContentText("This is Content")//内容
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(android.R.drawable.ic_dialog_alert)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_dialog_alert))
                    .build();
            startForeground(110, notification);
        }
        Log.i("TestService","onStartCommand");
        return START_STICKY;
    }
}
