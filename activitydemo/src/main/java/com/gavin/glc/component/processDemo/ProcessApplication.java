package com.gavin.glc.component.processDemo;

import android.app.Application;
import android.util.Log;

/**
 * Created by Gaoliangchao on 2018/7/16.
 * <p>
 * Description :
 */

public class ProcessApplication extends Application {
    private String TAG = "process_tag";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "ProcessApplication 创建");
    }
}
