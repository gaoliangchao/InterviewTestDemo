package com.gavin.glc.component.leakcanarydemo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public static Bitmap decodeBitmapForResource(Resources resources, int resId, int reqWidth, int reqHeight) {
        //先获取BitmapFactory中的Options对象，设置inJustDecodeBounds为true，让BitmapFactory只解析图片的宽高等相关属性
        //并不加载图
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        //读取图片获取对应信息
        BitmapFactory.decodeResource(resources, resId, options);
        //options读取信息
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSimpleSize = 1;
        return null;
    }
}
