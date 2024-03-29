package com.bailitop.study5.service;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BindImmediateService extends Service {
    private static final String TAG = "BindImmediateService";
    private final IBinder mBinder = new LocalBinder(); // 创建一个粘合剂对象

    public class LocalBinder extends Binder{
        public BindImmediateService getService(){
            return BindImmediateService.this;
        }
    }

    private void refresh(String text){
        Log.d(TAG, text);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refresh("onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        refresh("onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "绑定服务开始");
        refresh("onBind");
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        refresh("onRebind");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "绑定服务结束");
        refresh("onUnbind");
         super.onUnbind(intent);
         return true;

    }
}