package com.gavin.glc.component.leakcanarydemo;

import android.app.IntentService;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

import static com.gavin.glc.component.leakcanarydemo.Constant.SERVICE_TAG;

/**
 * Created by Gaoliangchao on 2018/7/18.
 * <p>
 * Description :
 */

public class MyIntentService extends IntentService {


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public MyIntentService() {
        super("MyIntentService");
        AsyncTask

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(SERVICE_TAG, "onHandleIntent: ");
        SystemClock.sleep(1000);

        int i = 0;
        while(i < 4){
            i++;
            SystemClock.sleep(2000);
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(SERVICE_TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        Log.d(SERVICE_TAG, "onDestroy: ");
        super.onDestroy();
    }
}
