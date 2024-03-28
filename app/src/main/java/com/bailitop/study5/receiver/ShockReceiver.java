package com.bailitop.study5.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;

import androidx.core.content.ContentValuesKt;

public class ShockReceiver extends BroadcastReceiver {
    private static final String TAG = "ShockReceiver";
    // 静态注册时候的action、发送广播时的action、接收广播时的action，三者需要保持一致
    public static final String SHOCK_ACTION = "com.bailitop.study5.shock";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        if(intent.getAction().equals(ShockReceiver.SHOCK_ACTION)){
            Vibrator vb = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);// 从系统服务中获取震动管理器
            vb.vibrate(15000); // 命令震动器吱吱个若干秒，这里的500表示500毫秒
        }
    }

}