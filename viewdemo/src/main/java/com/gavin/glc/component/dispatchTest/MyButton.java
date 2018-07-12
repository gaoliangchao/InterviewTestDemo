package com.gavin.glc.component.dispatchTest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Gaoliangchao on 2018/7/11.
 * <p>
 * Description :
 */

public class MyButton extends TextView {

    public static final String TAG = "MyButton";
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        String type = "other";
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                type = "down";
                break;
            case MotionEvent.ACTION_MOVE:
                if (true) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }

                type = "move";
                break;
            case MotionEvent.ACTION_UP:
                type = "up";
                break;
            default:
                type = event.getAction() + "";
        }
        Log.d(TAG, "MyButton dispatchTouchEvent"+ " " +type);
        return super.dispatchTouchEvent(event);
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
            default:
                type = event.getAction() + "";
        }
        Log.d(TAG, "MyButton onTouchEvent:" + " "+type);
//        if (event.getAction() == 0) {
//            return false;
//        }
        return super.onTouchEvent(event);
    }
}
