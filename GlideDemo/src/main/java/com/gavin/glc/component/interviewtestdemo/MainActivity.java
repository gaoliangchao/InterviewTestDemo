package com.gavin.glc.component.interviewtestdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image_view);
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.d("TAG", "Max memory is " + maxMemory + "KB");
        maxMemory = (int) maxMemory/1024;
        Log.d("TAG", "Max memory is " + maxMemory + "MB");

    }

    public void loadImage(View view) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        test6();

    }

    /**
     * 指定图片动态化
     * 如果加载的图片是一张静态图 则会直接加载失败
     */
    private void test6() {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(this)//创建加载图片的实例
                .load(url)//加载图片地址
                .asGif()
                .error(R.drawable.error)
                .placeholder(R.drawable.loading)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//设置缓存策略
                .into(imageView);//显示图片到控件
    }

    /**
     * 将Gif图片静态化
     */
    private void test5() {
        String url = "http://p1.pstatp.com/large/166200019850062839d3";
        Glide.with(this)//创建加载图片的实例
                .load(url)//加载图片地址
                .asBitmap()//只允许加载静态图片，不需要自动判断图片格式
                .error(R.drawable.error)
                .placeholder(R.drawable.loading)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//设置缓存策略
                .into(imageView);//显示图片到控件
    }

    /**
     * 显示Gif图片
     */
    private void test4() {
        String url = "http://p1.pstatp.com/large/166200019850062839d3";
        Glide.with(this)//创建加载图片的实例
                .load(url)//加载图片地址
                .error(R.drawable.error)
                .placeholder(R.drawable.loading)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//设置缓存策略
                .into(imageView);//显示图片到控件
    }

    /**
     * 加载图片的基本方式
     */
    private void test1() {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(this)//创建加载图片的实例
                .load(url)//加载图片地址
                .into(imageView);//显示图片到控件
    }

    /**
     * 加载图片设置占位图
     * 注意 diskCacheStrategy(DiskCacheStrategy.NONE) 只是为了能更好的显示占位图 所以关闭缓存
     */
    private void test2() {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(this)//创建加载图片的实例
                .load(url)//加载图片地址
                .placeholder(R.drawable.loading)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//设置缓存策略
                .into(imageView);//显示图片到控件
    }

    /**
     * 加载图片设置错误占位图
     */
    private void test3() {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(this)//创建加载图片的实例
                .load(url)//加载图片地址
                .error(R.drawable.error)
                .placeholder(R.drawable.loading)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//设置缓存策略
                .into(imageView);//显示图片到控件
    }


}
