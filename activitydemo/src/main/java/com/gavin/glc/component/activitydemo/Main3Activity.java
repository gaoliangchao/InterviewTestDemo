package com.gavin.glc.component.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gavin.glc.component.Tools;

public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        System.out.println("Main3Activity.onCreate: " + "________ taskId" + getTaskId());
        Tools.printTaskInfo(getApplicationContext());

    }

    public void enterOne(View view) {
        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Main3Activity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Main3Activity.onResume");
        Tools.printTaskInfo(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Main3Activity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Main3Activity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Main3Activity.onDestroy");
    }
}
