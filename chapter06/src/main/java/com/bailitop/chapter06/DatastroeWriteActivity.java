package com.bailitop.chapter06;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import util.DatastoreUtil;
import util.DateUtil;
import util.ToastUtil;

public class DatastroeWriteActivity  extends AppCompatActivity implements View.OnClickListener {
    private EditText et_name; // 声明一个编辑框对象
    private EditText et_age; // 声明一个编辑框对象
    private EditText et_height; // 声明一个编辑框对象
    private EditText et_weight; // 声明一个编辑框对象
    private boolean isMarried = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datastore_write);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        CheckBox ck_married = findViewById(R.id.ck_married);
        ck_married.setOnCheckedChangeListener((buttonView, isChecked) -> isMarried = isChecked);
        findViewById(R.id.btn_save).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_save){
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String height = et_height.getText().toString();
            String weight = et_weight.getText().toString();
            if(TextUtils.isEmpty(name)){
                ToastUtil.show(this, "请先填写姓名");
                return;
            } else if (TextUtils.isEmpty(age)) {
                ToastUtil.show(this, "请先填写姓名");
                return;
            }else if (TextUtils.isEmpty(height)) {
                ToastUtil.show(this, "请先填写身高");
                return;
            }else if (TextUtils.isEmpty(weight)) {
                ToastUtil.show(this, "请先填写体重");
                return;
            }
            DatastoreUtil datastore = DatastoreUtil.getInstance(this); // 获取数据仓库工具的实例
            datastore.setStringValue("name", name); // 添加一个名叫name的字符串
            datastore.setIntValue("age", Integer.parseInt(age));
            datastore.setIntValue("height", Integer.parseInt(height));
            datastore.setDoubleValue("weight",Double.parseDouble(weight));
            datastore.setBooleanValue("married", isMarried);
            datastore.setStringValue("update_time", DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss"));
            ToastUtil.show(this, "数据 已写入数据仓库");
        }
    }
}
