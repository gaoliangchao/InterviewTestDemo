package com.gavin.glc.component.designpatternsdemo;

import android.app.Activity;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :   主页条目的bean类
 */

public class DetailItem {

    private String name;

    private Class<? extends Activity> activityClass;

    public DetailItem() {
    }

    public DetailItem(String name, Class<? extends Activity> activityClass) {
        this.name = name;
        this.activityClass = activityClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<? extends Activity> getActivityClass() {
        return activityClass;
    }

    public void setActivityClass(Class<? extends Activity> activityClass) {
        this.activityClass = activityClass;
    }

    @Override
    public String toString() {
        return "DetailItem{" +
                "name='" + name + '\'' +
                ", activityClass=" + activityClass +
                '}';
    }
}
