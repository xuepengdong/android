package com.bailitop.study5;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.service.BindImmediateService;

public class bindImmediateActivity  extends AppCompatActivity implements View.OnClickListener {
    private static TextView tv_immediate;
    private static String mDesc;
    private Intent mIntent;

    private BindImmediateService mBindService; // 声明一个服务对象


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_immediate);
        tv_immediate    =   findViewById(R.id.tv_immediate);
        findViewById(R.id.btn_start_bind).setOnClickListener(this);
        findViewById(R.id.btn_unbind).setOnClickListener(this);
        mDesc   =   "";
        mIntent =   new Intent(this, BindImmediateService.class);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_start_bind){
            boolean bindFlag = bindService(mIntent, mServiceConn, Context.BIND_AUTO_CREATE);
            Log.d(TAG, "bindFlag" + bindFlag);
        }else if(v.getId() == R.id.btn_unbind){
            if(mBindService != null){
                unbindService(mServiceConn);
            }
        }
    }

    private ServiceConnection mServiceConn = new ServiceConnection() {

        //获取到服务对象时的操作
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBindService =  ((BindImmediateService.LocalBinder) service).getService();
            Log.d(TAG, "onServiceConnected");
        }

        //获取不到服务对象的操作
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBindService = null;
            Log.d(TAG, "onServiceDisconnected");
        }
    };
}
