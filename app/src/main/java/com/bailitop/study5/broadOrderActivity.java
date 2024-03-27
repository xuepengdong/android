package com.bailitop.study5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.BroadcastReceiver;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.util.DateUtil;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class broadOrderActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_order;
    private TextView ck_abort;
    private final static String ORDER_ACTION = "com.bailitop.study5.order";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_order);
        ck_abort = findViewById(R.id.ck_abort);
        tv_order = findViewById(R.id.tv_order);
        findViewById(R.id.btn_send_order).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_send_order){
            tv_order.setText("");
            Intent intent = new Intent(ORDER_ACTION);
            sendOrderedBroadcast(intent, null);
        }
    }

    protected void onStart(){
        super.onStart();
        // 多个接收器处理有序广播的顺序规则为：
        // 1、优先级越大的接收器，越早收到有序广播；
        // 2、优先级相同的时候，越早注册的接收器越早收到有序广播
        orderAReceiver = new OrderAReceiver(); // 创建一个有序广播的接收器
        IntentFilter fiterA = new IntentFilter(ORDER_ACTION);// 创建一个意图过滤器A，只处理ORDER_ACTION的广播
        fiterA.setPriority(8);// 设置过滤器A的优先级，数值越大优先级越高
        registerReceiver(orderAReceiver, fiterA);// 注册接收器A，注册之后才能正常接收广播

        orderBReceiver = new OrderBReceiver(); // 创建一个有序广播的接收器B
        IntentFilter filterB = new IntentFilter(ORDER_ACTION);// 创建一个意图过滤器A，只处理ORDER_ACTION的广播
        filterB.setPriority(7); // 设置过滤器B的优先级，数值越大优先级越高
        registerReceiver(orderBReceiver, filterB); // 注册接收器B，注册之后才能正常接收广播
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(orderAReceiver); // 注销接收器A，注销之后就不再接收广播
        unregisterReceiver(orderBReceiver); // 注销接收器B，注销之后就不再接收广播
    }


    private OrderAReceiver orderAReceiver; // 声明有序广播接收器A的实例

    private class OrderAReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent !=null && intent.getAction().equals(ORDER_ACTION)){
                String desc = String.format("%s%s 接收器A收到一个有序广播\n", tv_order.toString(), DateUtil.getNowTime());
                tv_order.setText(desc);
                if(ck_abort.isPressed()){
                    abortBroadcast(); // 中断广播，此时后面的接收器无法收到该广播
                }
            }
        }
        // 一旦接收到有序广播，马上触发接收器的onReceive方法

    }

    private OrderBReceiver orderBReceiver; // 声明有序广播接收器B的实例

    // 定义一个有序广播的接收器B
    private class OrderBReceiver extends BroadcastReceiver {
        // 一旦接收到有序广播B，马上触发接收器的onReceive方法
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals(ORDER_ACTION)) {
                String desc = String.format("%s%s 接收器B收到一个有序广播\n",
                        tv_order.getText().toString(), DateUtil.getNowTime());
                tv_order.setText(desc);
                if (ck_abort.isPressed()) {
                    abortBroadcast(); // 中断广播，此时后面的接收器无法收到该广播
                }
            }
        }
    }




}
