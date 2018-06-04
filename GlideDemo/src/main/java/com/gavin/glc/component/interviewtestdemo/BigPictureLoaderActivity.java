package com.gavin.glc.component.interviewtestdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class BigPictureLoaderActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_picture_loader);


        imageView = (ImageView) findViewById(R.id.image_view);

    }

    public void loadImage(View view) {
        imageView.setImageResource(R.mipmap.big_picture);
        //        test1();


    }

    private void test1() {
        //获取BitmapFactory工厂类的options内部类实例
        BitmapFactory.Options options = new BitmapFactory.Options();
        //修改属性 禁止为bitmap分配内存，返回值不再是Bitmap对象而是null
        //但是可以获取尺寸大小
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.big_picture, options);
        int outHeight = options.outHeight;
        int outWidth = options.outWidth;
        String outMimeType = options.outMimeType;
        Log.d("TAG", "The picture info: height-" + outHeight + " width-" + outWidth + " mimeType-" + outMimeType);
        Log.d("TAG", "The ImageView info: height-" + imageView.getHeight() + " width-" + imageView.getWidth());

        int inSampleSize = calculateInSampleSize(options, imageView.getWidth(), imageView.getHeight());
        Log.d("TAG", "The inSampleSize : " + inSampleSize);
        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),  R.mipmap.big_picture, options);
        imageView.setImageBitmap(bitmap);
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight | width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = Math.min(heightRatio, widthRatio);
        }
        return inSampleSize;
    }


}
