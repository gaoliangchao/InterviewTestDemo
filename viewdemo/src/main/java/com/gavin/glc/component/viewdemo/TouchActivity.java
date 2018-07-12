package com.gavin.glc.component.viewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.gavin.glc.component.customView.CustomView;

public class TouchActivity extends Activity {
    private FrameLayout activityTouch;
    private CustomView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        cv = (CustomView) findViewById(R.id.cv);


        activityTouch = (FrameLayout) findViewById(R.id.activity_touch);

        activityTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("CustomViewActivity", event.getAction() + " onTouch: x " + event.getRawX() + " y " + event.getRawY());
                cv.smoothScrollTo(((int) event.getRawX()),(int) event.getRawY());
                return false;
            }
        });
    }
}
