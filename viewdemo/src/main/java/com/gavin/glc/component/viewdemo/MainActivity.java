package com.gavin.glc.component.viewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView viewOne;
    private TextView viewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewOne = (TextView) findViewById(R.id.view_one);
        viewTwo = (TextView) findViewById(R.id.view_two);

    }

    public void myScrollTo(View view) {

        viewOne.scrollTo(40, 20);
    }

    public void myScrollBy(View view) {
        viewTwo.scrollBy(10, 4);
    }

    public void reset(View view) {
        viewOne.scrollTo(0, 0);
        viewTwo.scrollTo(0, 0);
    }
}
