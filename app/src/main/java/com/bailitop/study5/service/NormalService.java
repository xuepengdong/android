package com.bailitop.study5.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.bailitop.study5.serviceNormalActivity;

public class NormalService extends Service {
    private  static final String Tag = "NormalService";

    //调用serviceNormalActivity，把数据传递过去在视图中显示
    private void refresh(String text){
        Log.d(Tag, text);
        serviceNormalActivity.showText(text);
    }

    // 创建服务
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Tag, "onCreate启动服务");
        refresh("onCreate启动服务");
    }

    // 启动服务，Android2.0以上使用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Tag, "onStartCommand启动服务");
        refresh("onStartCommand.flags=启动服务，Android2.0以上使用" + flags);
        return super.onStartCommand(intent, flags, startId);
    }

    //销毁服务
    @Override
    public void onDestroy() {
        Log.d(Tag, "onDestroy销毁服务");
        refresh("onDestroy,销毁服务");
        super.onDestroy();
    }

    //绑定服务。普通服务不存在绑定和解绑流程
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Tag, "onBind绑定服务");
        refresh("绑定服务。普通服务不存在绑定和解绑流程");
        return null;
    }

    //重新绑定服务
    @Override
    public void onRebind(Intent intent) {
        Log.d(Tag, "onRebind重新绑定服务");
        super.onRebind(intent);
    }

    //解绑服务
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Tag, "onUnbind解绑服务");
        refresh("onUnbind解绑服务，返回false表示只能绑定一次，返回true表示允许多次绑定");
        return super.onUnbind(intent);
    }

    //内存不足时调用
    @Override
    public void onLowMemory() {
        Log.d(Tag, "内存不足时调用");
        refresh("onLowMemory内存不足时调用");
        super.onLowMemory();
    }


}