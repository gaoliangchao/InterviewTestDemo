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

public class Process1Activity extends Activity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process1);

        Tools.printProcessId(this.getClass().getSimpleName(),getApplicationContext());
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Process1Activity.this, Process2Activity.class));
            }
        });
    }

    public void setValues(View view) {

        Constant.desc = "process1Activity";
        Log.i(Constant.TAG, "Constant: " + Constant.desc);
    }
}
