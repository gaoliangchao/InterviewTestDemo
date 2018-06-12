package com.gavin.glc.component.servicedemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class ForegroundService extends Service {
    private String TAG = "Foreground";

    public ForegroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        Intent intent = new Intent(this, ForegroundActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this, null)
                .setContentTitle("This is content title")       //指定通知的标题内容
                .setContentText("This is content text")         //指定通知的正文内容
                .setWhen(System.currentTimeMillis())            //指定通知被创建的时间
                .setSmallIcon(R.mipmap.ic_launcher)             //指定通知小图标 在系统状态栏上显示
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))//指定通知的大图标，下拉系统状态栏后显示
                .setContentIntent(pi)                           //指定点击通知后的延迟意图
                .build();
        startForeground(1,notification);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();

    }
}
