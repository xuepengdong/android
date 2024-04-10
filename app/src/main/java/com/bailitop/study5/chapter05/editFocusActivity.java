package com.bailitop.study5.chapter05;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.R;

public class editFocusActivity  extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    private EditText et_phone;
    private EditText et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_focus);
        et_phone = findViewById(R.id.et_phone);
        et_password = findViewById(R.id.et_password);
        et_password.setOnClickListener(this);
        et_password.setOnFocusChangeListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(v.getId() == R.id.et_password && hasFocus){
            String phone = et_phone.getText().toString();

            if(TextUtils.isEmpty(phone) || phone.length() < 11){
                et_phone.requestFocus();
                Toast.makeText(this, "请输入11位手机号码", Toast.LENGTH_SHORT).show();

            }
        }
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.et_password){
            String phone = et_phone.getText().toString();
            if(TextUtils.isEmpty(phone) || phone.length() < 11){
                et_phone.requestFocus();
                Toast.makeText(this, "请输入11位手机号码", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId()  == R.id.btn_login) {
            String password = et_password.getText().toString();
            if(TextUtils.isEmpty(password) || password.length()< 11){
                et_password.requestFocus();
                Toast.makeText(this, "请输入6位密码", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
