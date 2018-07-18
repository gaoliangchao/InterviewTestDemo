package com.gavin.glc.component.leakcanarydemo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Gaoliangchao on 2018/7/12.
 * <p>
 * Description :
 */

public class ToastUtils {

    private static Toast toast;

    public static void showToast(Context context, String msg) {

        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }

        toast.setText(msg);
        toast.show();
    }
}
