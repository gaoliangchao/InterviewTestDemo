package com.gavin.glc.component.leakcanarydemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterLeakOne(View view) {
        Message obtain = Message.obtain();
        obtain.callback =
        startActivity(new Intent(this, LeakOneActivity.class));
    }

    public void enterLeakTwo(View view) {

        startActivity(new Intent(this, LeakTwoActivity.class));
    }

    public void startIntentService(View view) {

        Intent intent = new Intent("com.gavin.glc.component.componentdemo.static.action");
        intent.putExtra("content", "我是另一个应用");
//        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
//        startService(new Intent(this, MyIntentService.class));
    }
}
