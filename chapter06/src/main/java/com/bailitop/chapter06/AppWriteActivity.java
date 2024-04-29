package com.bailitop.chapter06;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import util.DateUtil;
import util.ToastUtil;

public class AppWriteActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private EditText et_name;
    private EditText et_age;
    private EditText et_weight;
    private EditText et_height;
    private CheckBox ck_married;
    private Button btn_save;
    private boolean isMarried = false;
    private String[] typeArray = {"未婚", "已婚"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_write);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_weight = findViewById(R.id.et_weight);
        et_height = findViewById(R.id.et_height);
        ck_married = findViewById(R.id.ck_married);
        ck_married.setOnCheckedChangeListener(this);
        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        isMarried = isChecked;
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
            }else if (TextUtils.isEmpty(age)) {
                ToastUtil.show(this, "请先填写年龄");
                return;
            } else if (TextUtils.isEmpty(height)) {
                ToastUtil.show(this, "请先填写身高");
                return;
            } else if (TextUtils.isEmpty(weight)) {
                ToastUtil.show(this, "请先填写体重");
                return;
            }
            MainApplication app = MainApplication.getInstance();
            app.infoMap.put("name", name);
            app.infoMap.put("age", age);
            app.infoMap.put("height", height);
            app.infoMap.put("weight", weight);
            app.infoMap.put("married", typeArray[!isMarried ? 0 : 1]);
            app.infoMap.put("update_time", DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss"));
            ToastUtil.show(this, "数据已写入全局内存");
        }
    }
}
