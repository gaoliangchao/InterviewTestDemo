package com.gavin.glc.component.leakcanarydemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class LeakTwoActivity extends Activity {
    private TextView tv;

    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_two);

        tv = (TextView) findViewById(R.id.tv);

    }

    public void sendMsg(View view) {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setText("显示出来了");
            }
        }, 3 * 60 * 1000);
    }
}
