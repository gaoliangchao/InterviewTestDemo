package com.gavin.glc.component.designpatternsdemo.FactoryPattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

import com.gavin.glc.component.designpatternsdemo.R;

public class FactoryActivity extends AppCompatActivity {
    private Button btnOne;
    private Button btnTwo;

    private ViewStub vs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);


        vs = (ViewStub) findViewById(R.id.vs);

        btnOne = (Button) findViewById(R.id.btn_one);
        btnTwo = (Button) findViewById(R.id.btn_two);
        final BaseFactory factory = new CarFactory();
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Car honda = factory.create("honda");
//                honda.driver();
//                honda.money();
                vs.setVisibility(View.VISIBLE);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car honda = factory.create("audi");
                honda.driver();
                honda.money();
                vs.setVisibility(View.GONE);
            }
        });

    }
}
