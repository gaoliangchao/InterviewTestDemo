package com.gavin.glc.component.activitydemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gavin.glc.component.Tools;

public class MainActivity extends Activity {
    private TextView tv;
    private EditText ed;
    private ActivityManager systemService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("MainActivity.onCreate: " + "________ taskId" + getTaskId());

        ed = (EditText) findViewById(R.id.ed);

        tv = (TextView) findViewById(R.id.tv);
        if (savedInstanceState != null && savedInstanceState.containsKey("tv")) {
            tv.setText(savedInstanceState.getString("tv"));
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("MainActivity.onNewIntent");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //        outState.putString("tv", tv.getText().toString());
        super.onSaveInstanceState(outState);
        System.out.println("MainActivity.onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("MainActivity.onRestoreInstanceState ");
    }


    public void fun1(View view) {
        startActivity(new Intent(this, MainActivity.class));
        //        ed.setText("啦啦啦啦啦");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity.onResume");
        Tools.printTaskInfo(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActivity.onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity.onDestroy");
    }
}
