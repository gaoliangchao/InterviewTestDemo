package com.gavin.glc.component.leakcanarydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Gaoliangchao on 2018/7/12.
 * <p>
 * Description :
 */

public class LeakOneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_one);
    }

    public void fun1(View view) {
        ToastUtils.showToast(LeakOneActivity.this, "我是Toast提示");
    }

}
