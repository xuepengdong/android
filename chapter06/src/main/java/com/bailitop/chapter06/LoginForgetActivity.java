package com.bailitop.chapter06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class LoginForgetActivity  extends AppCompatActivity implements View.OnClickListener {
    private EditText et_password_first;
    private EditText et_password_second;
    private EditText et_verifycode;
    private  Button btn_verifycode;
    private  Button btn_confirm;
    private String mPhone;
    private String mVerifyCode;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_forget);
        et_password_first = findViewById(R.id.et_password_first);
        et_password_second = findViewById(R.id.et_password_second);
        et_verifycode = findViewById(R.id.et_verifycode);
        btn_verifycode = findViewById(R.id.btn_verifycode);
        btn_confirm = findViewById(R.id.btn_confirm);
        btn_verifycode.setOnClickListener(this);
        btn_confirm.setOnClickListener(this);
        // 从上一个页面获取要修改密码的手机号码
        mPhone = getIntent().getStringExtra("phone");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_verifycode){
            if(mPhone == null || mPhone.length() <11){
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            mVerifyCode = String.format("%06d", new Random().nextInt(99999));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("请记住验证码");
            builder.setMessage("手机号" + mPhone + ",本次验证码是"+mVerifyCode+",请输入验证码");
            builder.setPositiveButton("好的", null);
            AlertDialog alert = builder.create();
            alert.show();
        } else if (v.getId() == R.id.btn_confirm) {
            String password_firt = et_password_first.getText().toString();
            String password_second = et_password_second.getText().toString();

            if(password_firt.length() < 6 || password_second.length() <6){
                Toast.makeText(this, "密码不正确", Toast.LENGTH_SHORT).show();
                return;
            }

            if(!password_firt.equals(password_second)){
                Toast.makeText(this, "两次的输入验证码不一致", Toast.LENGTH_SHORT).show();
                return;
            }

            if(!et_verifycode.getText().toString().equals(mVerifyCode)){
                Toast.makeText(this, "验证码输入不正确", Toast.LENGTH_SHORT).show();
                return;
            }else{
                Toast.makeText(this, "密码修改成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("new password", password_firt);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        }
    }
}
