package com.gavin.glc.component.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BinderActivity extends AppCompatActivity {

    private Button button;

    private Button button2;
    private String TAG = "BinderTest";
    private MyServiceConnection myServiceConnection = new MyServiceConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BinderActivity.this, BinderService.class);
                bindService(intent, myServiceConnection, BIND_AUTO_CREATE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(myServiceConnection);
            }
        });
    }


    class MyServiceConnection implements ServiceConnection {

        private BinderService.DownloadBinder downloadBinder;

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: ");
            downloadBinder = ((BinderService.DownloadBinder) service);
            downloadBinder.startDownload();
            downloadBinder.updateProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
        }

        @Override
        public void onBindingDied(ComponentName name) {
            Log.d(TAG, "onBindingDied: ");
        }
    }
}
