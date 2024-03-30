package com.bailitop.study5;

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

import com.bailitop.study5.service.DataService;
import com.bailitop.study5.util.DateUtil;

import java.util.Random;


public class serviceDataActivity  extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "serviceDataActivity";
    private TextView tv_result;
    private Intent mIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_data);
        tv_result = findViewById(R.id.tv_result);
        findViewById(R.id.btn_start_bind).setOnClickListener(this);
        findViewById(R.id.btn_unbind).setOnClickListener(this);
        mIntent = new Intent(this, DataService.class);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_start_bind){
            boolean bindFlag = bindService(mIntent, mServiceConn, Context.BIND_AUTO_CREATE);
            Log.d(TAG, "bindFlag=" + bindFlag);
        }
    }

    private DataService.LocalBinder mBinder; // 声明一个粘合剂对象
    private ServiceConnection mServiceConn = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            // 如果服务运行于另外一个进程，则不能直接强制转换类型，否则会报错
            mBinder = (DataService.LocalBinder) service;
            // 活动代码通过粘合剂与服务代码通信
            String response = mBinder.getNumber(new Random().nextInt(100));
            tv_result.setText(DateUtil.getNowTime()+" 绑定服务应答："+response);
            Log.d(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBinder = null;
            Log.d(TAG, "onServiceDisconnected");
        }
    };
}
