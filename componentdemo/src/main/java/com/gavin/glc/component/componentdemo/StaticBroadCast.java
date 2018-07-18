package com.gavin.glc.component.componentdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class StaticBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "静态广播：" + intent.getStringExtra("content"), Toast.LENGTH_SHORT).show();
    }
}
