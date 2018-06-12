package com.gavin.glc.component.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * 关于服务中的onBind用法
 */
public class BinderService extends Service {
    private String TAG = "BinderTest";
    public DownloadBinder mBinder = new DownloadBinder();

    public BinderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return mBinder;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.d(TAG, "onStart: ");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();

    }

    class DownloadBinder extends Binder {

        public void startDownload() {
            Log.d(TAG, "startDownload: ");
        }

        public int updateProgress() {
            Log.d(TAG, "updateProgress: ");
            return 0;
        }

    }
}
