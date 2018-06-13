package com.gavin.glc.component.downloaddemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DownloaderService.DownloadBinder binder = (DownloaderService.DownloadBinder) service;
            binder.startDownload("http://ddride-apk.oss-cn-shanghai.aliyuncs.com/SpecialTrainClient1.3.0.apk");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void download(View view) {

        Intent intent = new Intent(this, DownloaderService.class);
        startService(intent);
        bindService(intent, sc, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            unbindService(sc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
