package com.bailitop.chapter06;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import bean.UserInfo;
import database.UserDBHelper;
import util.DateUtil;
import util.ToastUtil;

public class SQLiteWriteActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private EditText et_weight;
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;

    private boolean isMarried = false;

    private UserDBHelper mHelper; // 声明一个用户数据库帮助器的对象

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqllite_write);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);

        CheckBox ck_married = findViewById(R.id.ck_married);
        ck_married.setOnCheckedChangeListener(this);
        findViewById(R.id.btn_save).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 获得数据库帮助器的实例
        mHelper = UserDBHelper.getInstance(this, 1);
        mHelper.openWriteLink(); // 打开数据库帮助器的写连接
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHelper.closeLink(); // 关闭数据库连接
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        isMarried = isChecked;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_save){
            String  name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String height = et_height.getText().toString();
            String weight = et_weight.getText().toString();
            if(TextUtils.isEmpty(name)){
                ToastUtil.show(this, "请填写姓名");
                return;
            }else if(TextUtils.isEmpty(age)) {
                ToastUtil.show(this, "请填写年龄");
                return;
            }else  if(TextUtils.isEmpty(height)){
                ToastUtil.show(this, "请填写身高");
                return;
            }else  if(TextUtils.isEmpty(weight)){
                ToastUtil.show(this, "请填写体重");
                return;
            }
            UserInfo info = new UserInfo();
            info.name= name;
            info.age =  Integer.parseInt(age);
            info.height = Long.parseLong(height);
            info.weight = Float.parseFloat(weight);
            info.married = isMarried;
            info.update_time = DateUtil.getNowDateTime("yy-MM-dd HH:mm:ss");
            mHelper.insert(info);
            ToastUtil.show(this, "数据已写入SQLLite数据库");
        }
    }
}
