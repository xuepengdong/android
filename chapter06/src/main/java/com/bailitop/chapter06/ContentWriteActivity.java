package com.bailitop.chapter06;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import bean.UserInfo;
import provider.UserInfoContent;
import util.DateUtil;
import util.ToastUtil;

public class ContentWriteActivity  extends AppCompatActivity implements View.OnClickListener {
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_write);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        findViewById(R.id.btn_add_user).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() ==R.id.btn_add_user){
            UserInfo user = new UserInfo();
            user.name = et_name.getText().toString();
            user.age = Integer.parseInt(et_age.getText().toString());
            user.weight = Float.parseFloat(et_weight.getText().toString());
            user.height = Integer.parseInt(et_height.getText().toString());
            addUser(user);
        }

    }

    private void addUser(UserInfo user){
        ContentValues name = new ContentValues();
        name.put("name", user.name);
        name.put("age", user.age);
        name.put("weight", user.weight);
        name.put("height", user.height);
        name.put("married", 0);
        name.put("update_time", DateUtil.getNowDateTime(""));
        getContentResolver().insert(UserInfoContent.CONTENT_URI, name);
        ToastUtil.show(this, "成功添加用户信息");

    }
}
