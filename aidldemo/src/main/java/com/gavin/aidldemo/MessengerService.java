package com.gavin.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MessengerService extends Service {
    public MessengerService() {
    }

    public static final int SEND_TAG = 123456;
    public static final int REPLU_TAG = 34567;

    public static final String LOG_TAG = "MESSENGER";
    public static class MessengerHandler extends Handler{

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SEND_TAG:
                    Log.d(LOG_TAG, "MessengerService receiver client message : " + msg.getData().getString("msg"));
                    Messenger replyTo = msg.replyTo;
                    Message reply = Message.obtain(null, REPLU_TAG);
                    Bundle bundle = new Bundle();
                    bundle.putString("reply", "收到客户端的请求发起回应");
                    reply.setData(bundle);
                    try {
                        replyTo.send(reply);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }


        }
    }

    private final Messenger mMessenger = new Messenger(new MessengerHandler());
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }
}
