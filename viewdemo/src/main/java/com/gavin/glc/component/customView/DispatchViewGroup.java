package com.gavin.glc.component.customView;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by Gaoliangchao on 2018/7/10.
 * <p>
 * Description :
 */

public class DispatchViewGroup extends ViewGroup {
    public DispatchViewGroup(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
