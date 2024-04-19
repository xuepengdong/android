package com.bailitop.chapter06;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import util.ToastUtil;
import util.DateUtil;

public class ShareWriteActivity  extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener  {
    private EditText et_name;
    private static final String TAG = "ShareWriteActivity";
    private EditText et_age;
    private EditText et_height;
    private  EditText et_weight;
    private  boolean isMarried = false;

    private SharedPreferences mShared;//声明共享参数对象


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_write);
        et_name = findViewById(R.id.et_name);
//        Log.d(TAG, "et_name value: " + et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        CheckBox ck_married = findViewById(R.id.ck_married);
        ck_married.setOnCheckedChangeListener(this);
        findViewById(R.id.btn_save).setOnClickListener(this);
        mShared = getSharedPreferences("share", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_save){
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String height = et_height.getText().toString();
            String weight = et_weight.getText().toString();
            if(TextUtils.isEmpty(name)){
                ToastUtil.show(this, "请填写姓名");
                return;
            } else if (TextUtils.isEmpty(age)) {
                ToastUtil.show(this, "请填写年龄");
                return;
            }else if (TextUtils.isEmpty(height)) {
                ToastUtil.show(this, "请填写身高");
                return;
            }else if (TextUtils.isEmpty(weight)) {
                ToastUtil.show(this, "请填写体重");
                return;
            }

            SharedPreferences.Editor editor = mShared.edit();//获取编辑器的对象
            editor.putString("name", name);
            editor.putInt("age", Integer.parseInt(age));
            editor.putLong("height",Long.parseLong(height));
            editor.putFloat("weight", Float.parseFloat(weight));
            editor.putBoolean("married",  isMarried);
            editor.putString("update_time", DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss"));
            editor.commit();
            ToastUtil.show(this, "数据已写入共享参数");
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        isMarried = isChecked;
    }



}
