package com.gavin.glc.component;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.List;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created by Gaoliangchao on 2018/7/15.
 * <p>
 * Description :
 */

public class Tools {
    public static String TAG = "process_tag";
    public static void printTaskInfo(Context context) {
        ActivityManager systemService = ((ActivityManager) context.getSystemService(ACTIVITY_SERVICE));
        List<ActivityManager.RunningTaskInfo> runningTasks = systemService.getRunningTasks(1);
        ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
        System.out.println("栈名称：" + runningTaskInfo.baseActivity+ " 栈id：" + runningTaskInfo.id);
    }

    public static void printProcessId(String name,Context context) {
        int pid = android.os.Process.myPid();
        String processName = "";
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);

        List<ActivityManager.RunningAppProcessInfo> list = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list){
            if (runningAppProcessInfo.pid == pid){
                processName = runningAppProcessInfo.processName;
            }
        }

        Log.i(TAG,name + "当前进程名称:" + processName +"  当前进程id：" +pid);
    }
}
