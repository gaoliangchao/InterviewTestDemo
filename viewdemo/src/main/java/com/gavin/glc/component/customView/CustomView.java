package com.gavin.glc.component.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

import com.nineoldandroids.view.ViewHelper;


/**
 * Created by Gaoliangchao on 2018/7/10.
 * <p>
 * Description :    随手移动的View
 */

public class CustomView extends View {

    private static final String TAG = "CustomView";

    //最后记录的x值
    private int lastX;
    //最后记录的y值
    private int lastY;
    //最小移动的距离
    private final int touchSlop;
    private Scroller scroller;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        Log.d(TAG, "CustomView: " + "touchSlop --- " + touchSlop);
        scroller = new Scroller(context);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        int x1 = (int) event.getX();
        int y1 = (int) event.getY();

        Log.d(TAG, "onTouchEvent: Action " + event.getAction() + " x " + x + "  y " + y + "____ x1 " + x1 + "  y1 " + y1);
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                break;

            case MotionEvent.ACTION_MOVE:
                int deltaX = x - lastX;
                int deltaY = y - lastY;
                Log.d(TAG, "onTouchEvent: deltaX " + deltaX + "  deltaY " + deltaY);
                //                if (Math.abs(deltaX) < touchSlop && Math.abs(deltaY) < touchSlop) {
                //                    Log.d(TAG, "onTouchEvent: 终止————————————————" );
                //                    return true;
                //                }

                //nineOlderMethod(deltaX, deltaY);
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin += deltaX;
                layoutParams.topMargin += deltaY;
                requestLayout();

                break;

            case MotionEvent.ACTION_UP:

                break;

            default:

                break;
        }

        lastX = x;
        lastY = y;
        return true;
    }

    private void nineOlderMethod(int deltaX, int deltaY) {
        int translationX = ((int) ViewHelper.getTranslationX(this)) + deltaX;
        int translationY = ((int) ViewHelper.getTranslationY(this)) + deltaY;
        ViewHelper.setTranslationX(this, translationX);
        ViewHelper.setTranslationY(this, translationY);
    }


    public void smoothScrollTo(int destX, int destY) {
        int scrollX = (int) getX();
        int scrollY = (int) getY();
        Log.d(TAG, "onTouchEvent: getX " + getX() + "  getY " + getY());
        int deltaX = destX - scrollX - getWidth()/2;
        int deltaY = destY - scrollY - getHeight()/2;
        scroller.startScroll(scrollX, scrollY, deltaX, deltaY, 1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
//            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            layoutParams.leftMargin = scroller.getCurrX();
            layoutParams.topMargin = scroller.getCurrY();
            requestLayout();
//            Log.d(TAG, "onTouchEvent: getCurrX " + scroller.getCurrX() + "  getCurrY " + scroller.getCurrY());
//            postInvalidate();
        }
    }
}
