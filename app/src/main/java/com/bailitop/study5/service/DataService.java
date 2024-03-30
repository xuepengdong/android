package com.bailitop.study5.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataService  extends Service {
    private static final String TAG = "DataService";
    private final IBinder mBinder = new LocalBinder();


    public class LocalBinder extends Binder {
        public DataService getService(){
            return DataService.this;
        }

        public String getNumber(int number){
            return "接受到了" +number;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "绑定服务开始");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "解绑服务");
        return super.onUnbind(intent);
    }
}
