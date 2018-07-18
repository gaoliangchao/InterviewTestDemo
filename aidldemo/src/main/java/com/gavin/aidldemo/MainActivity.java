package com.gavin.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import static com.gavin.aidldemo.MessengerService.LOG_TAG;
import static com.gavin.aidldemo.MessengerService.REPLU_TAG;
import static com.gavin.aidldemo.MessengerService.SEND_TAG;

public class MainActivity extends AppCompatActivity {
    private Messenger messenger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Messenger mGetReplyMessenger = new Messenger(new MessengerHandler());
    public static class MessengerHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REPLU_TAG:
                    Log.d(LOG_TAG, "客户端收到服务端的回应  : " + msg.getData().getString("reply"));

                    break;
                default:
                    super.handleMessage(msg);
            }


        }
    }
    private ServiceConnection mConnection = new ServiceConnection() {


        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            Message msg = Message.obtain(null, SEND_TAG);
            Bundle bundle = new Bundle();
            bundle.putString("msg", "hello,this is client");
            msg.setData(bundle);
            msg.replyTo = mGetReplyMessenger;
            try {
                messenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void fun1(View view) {
        Intent intent = new Intent(this, MessengerService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        Log.d(LOG_TAG, "fun1: 点击");
    }
}
