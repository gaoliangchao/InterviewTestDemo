package com.gavin.glc.component.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Android系统提供的 可以简单地创建一个异步的、会自动停止的服务
 */
public class MyIntentService extends IntentService {

    private String TAG = getClass().getSimpleName();

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: " + "Thread id is" + Thread.currentThread().getId());
        Log.d(TAG, "onCreate: " + "Thread name is" + Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: " + "Thread id is" + Thread.currentThread().getId());
        Log.d(TAG, "onStartCommand: " + "Thread name is" + Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: " + "Thread id is" + Thread.currentThread().getId());
        Log.d(TAG, "onHandleIntent: " + "Thread name is" + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: " + "Thread id is" + Thread.currentThread().getId());
        Log.d(TAG, "onDestroy: " + "Thread name is" + Thread.currentThread().getName());
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
