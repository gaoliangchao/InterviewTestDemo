package com.gavin.glc.component.dispatchTest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Gaoliangchao on 2018/7/11.
 * <p>
 * Description :
 */

public class MyRelativeLayout extends RelativeLayout {

    public static final String TAG = "MyRelativeLayout";

    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
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
        Log.d(TAG, "MyRelativeLayout dispatchTouchEvent"+"  " +type);
        return super.dispatchTouchEvent(ev);
    }

    private int i = 0;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepter = false;
        String type = "other";
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                type = "down";
                intercepter = false;
                break;
            case MotionEvent.ACTION_MOVE:
                type = "move";

                intercepter = true;

                break;
            case MotionEvent.ACTION_UP:
                type = "up";
                intercepter = true;
                break;
        }
        Log.d(TAG, "MyRelativeLayout onInterceptTouchEvent "  +type);
        return intercepter;
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
        Log.d(TAG, "MyRelativeLayout onTouchEvent"+"  " +type);
        return super.onTouchEvent(event);
    }
}
