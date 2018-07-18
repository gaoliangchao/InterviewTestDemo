package com.gavin.glc.component.processDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gavin.glc.component.Tools;
import com.gavin.glc.component.activitydemo.R;

public class Process3Activity extends Activity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process3);
        Tools.printProcessId(this.getClass().getSimpleName(),getApplicationContext());
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(Process3Activity.this, Process3Activity.class));
            }
        });
    }
}
