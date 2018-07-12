package com.gavin.glc.component.dispatchTest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.gavin.glc.component.viewdemo.R;

public class DispatchActivity extends Activity {
    private MyButton btn;
    private MyRelativeLayout activityDispatch;
    public static final String TAG = "DispatchActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);


        activityDispatch = (MyRelativeLayout) findViewById(R.id.activity_dispatch);
        activityDispatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "DispatchActivity MyRelativeLayout onclick");
            }
        });

        btn = (MyButton) findViewById(R.id.btn);
//        btn.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                String type = "other";
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        type = "down";
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        type = "move";
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        type = "up";
//                        break;
//                }
//                Log.d(TAG, " button onTouch " + " " + type);
//                return false;
//            }
//        });

    }

    public void fun1(View view) {
        Log.d(TAG, "DispatchActivity onclick");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "DispatchActivity 开始*************************");
        String type = "other";
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                type = "down";
                break;
            case MotionEvent.ACTION_MOVE:
                type = "move";
                break;
            case MotionEvent.ACTION_UP:
                type = "up";
                break;
        }
        Log.d(TAG, "DispatchActivity dispatchTouchEvent" +"  " +type);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String type = "other";
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                type = "down";
                break;
            case MotionEvent.ACTION_MOVE:
                type = "move";
                break;
            case MotionEvent.ACTION_UP:
                type = "up";
                break;
        }
        Log.d(TAG, "DispatchActivity onTouchEvent"+"  " +type);
        return super.onTouchEvent(event);
    }
}
