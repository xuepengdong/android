package com.bailitop.study5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.service.NormalService;
import com.bailitop.study5.util.DateUtil;

public class serviceNormalActivity extends AppCompatActivity implements View.OnClickListener {
    private static TextView tv_normal;
    private static String mDesc;
    private static String desc;

    private Intent mIntent; //声明一个意图对象

    /**
     * {@inheritDoc}
     * <p>
     * Perform initialization of all fragments.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_normal);
        tv_normal = findViewById(R.id.tv_normal);
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
        mDesc = "";
        // 创建一个通往普通服务的意图
        mIntent = new Intent(this, NormalService.class);
    }



    //通过点击跳转到对应的意图服务
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_start){
            startService(mIntent);// 启动指定意图的服务
        }else{
            stopService(mIntent);// 停止指定意图的服务
        }
    }

    public static void showText(String desc){
        if(tv_normal != null){
            mDesc = String.format("%s%s %s\n", mDesc, DateUtil.getNowDateTime("HH:mm:ss"), desc);
            tv_normal.setText(mDesc);
        }
    }
}
