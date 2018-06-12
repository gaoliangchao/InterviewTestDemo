package com.gavin.glc.component.servicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class IntentServiceActivity extends AppCompatActivity {
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyIntentService", "onClick: " + "Thread id is" + Thread.currentThread().getId());
                Log.d("MyIntentService", "onClick: " + "Thread name is" + Thread.currentThread().getName());
                Intent intent = new Intent(IntentServiceActivity.this, MyIntentService.class);
                startService(intent);
            }
        });

    }
}
