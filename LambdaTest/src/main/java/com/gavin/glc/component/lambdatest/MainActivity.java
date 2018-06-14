package com.gavin.glc.component.lambdatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        new Thread(() -> {
        //
        //        }).start();
        //        MyListener listener = (a, b) -> {
        //
        //            return a + b;
        //        };
        //        hello(listener);
        hello((a, b) -> {
            return a + b;
        });


    }

    interface MyListener {
        String doSomething(String a, int b);
    }

    public void hello(MyListener listener) {

        String a = "Hello Lambda";
        int b = 1024;
        String result = listener.doSomething(a, b);
        Log.d("hello", "hello: " + result);
    }
}
