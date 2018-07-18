package com.gavin.glc.component.processDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gavin.glc.component.Constant;
import com.gavin.glc.component.Tools;
import com.gavin.glc.component.activitydemo.R;



public class Process2Activity extends Activity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process2);
        Tools.printProcessId(this.getClass().getSimpleName(),getApplicationContext());
        Log.i(Constant.TAG, "Constant: " + Constant.desc);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Process2Activity.this, Process3Activity.class));
            }
        });
    }
}
