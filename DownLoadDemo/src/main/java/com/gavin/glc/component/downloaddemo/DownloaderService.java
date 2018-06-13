package com.gavin.glc.component.downloaddemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Gaoliangchao on 2018/6/13.
 * <p>
 * Description :
 */

public class DownloaderService extends Service {

    private DownLoader downLoader;
    private DownloadListener downloadListener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(324, getNotification("Downloading", progress));
        }

        @Override
        public void onSuccess() {
            downLoader = null;
            stopForeground(true);
            getNotificationManager().notify(324, getNotification("Download Success", -1));
            Toast.makeText(DownloaderService.this, "Download Success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFail() {

        }

    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new DownloadBinder();
    }

    private NotificationManager getNotificationManager() {

        return ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
    }
    class DownloadBinder extends Binder{

        public void startDownload(String path) {
            if (downLoader == null) {

                downLoader = new DownLoader(getApplicationContext(),"abd.apk",downloadListener);
                downLoader.execute(path);
                startForeground(324,getNotification("Downloading...",0));
                Toast.makeText(DownloaderService.this, "Downloading...", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private Notification getNotification(String s, int i) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, null);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .setContentTitle(s);
        if (i>0) {
            builder.setContentText(i + "%");
            builder.setProgress(100, i, false);
        }
        return builder.build();
    }


}
