package com.gavin.glc.component.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gavin.glc.component.Tools;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        System.out.println("Main2Activity.onCreate "+ "________ taskId" + getTaskId());
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Main2Activity.onStart");
    }

    public void enter3(View view) {

        startActivity(new Intent(this,Main3Activity.class));
    }
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Main2Activity.onResume");
        Tools.printTaskInfo(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Main2Activity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Main2Activity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Main2Activity.onDestroy");
    }
}
