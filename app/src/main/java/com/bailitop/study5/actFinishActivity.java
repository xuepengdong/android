package com.bailitop.study5;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class actFinishActivity  extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_finish);

        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.btn_finish).setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.iv_back){
            finish();
        }

        if(v.getId() == R.id.btn_finish){
            // 创建对话框构建器
            AlertDialog.Builder builder = new AlertDialog.Builder(actFinishActivity.this);
            builder.setTitle("标题");
            builder.setMessage("这是一个弹出框的内容");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 点击确定按钮后的操作
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 点击取消按钮后的操作
                    dialog.cancel();
                }
            });

            // 显示对话框
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
