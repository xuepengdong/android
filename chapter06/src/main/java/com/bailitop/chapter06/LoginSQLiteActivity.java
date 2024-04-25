package com.bailitop.chapter06;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import bean.UserInfo;
import database.UserDBHelper;
import util.DateUtil;
import util.ToastUtil;
import util.ViewUtil;

public class LoginSQLiteActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    private RadioGroup rg_login;
    private RadioButton rb_password;
    private RadioButton rb_verifycode;
    private TextView tv_phone;
    private EditText et_phone;
    private TextView tv_password;
    private EditText et_password;
    private Button btn_forget;
    private CheckBox ck_remember;
    private boolean isRemember = false; // 是否记住密码
    private int mRequestCode = 0; // 跳转页面时的请求代码
    private String mVerifyCode; // 验证码
    private String mPassword = "111111"; // 默认密码
    private UserDBHelper mHelper; // 声明一个用户数据库的帮助器对象


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sqlite);
        rg_login = findViewById(R.id.rg_login);
        rb_password = findViewById(R.id.rb_password);
        rb_verifycode = findViewById(R.id.rb_verifycode);
        tv_phone = findViewById(R.id.tv_phone);
        et_password = findViewById(R.id.et_password);
        btn_forget = findViewById(R.id.btn_forget);
        ck_remember = findViewById(R.id.ck_remember);
        et_phone = findViewById(R.id.et_phone);
        rg_login.setOnCheckedChangeListener(new  RadioListener());
        ck_remember.setOnCheckedChangeListener((buttonView, isChecked) -> isRemember=isChecked);
        et_phone.addTextChangedListener(new HideTextWatcher(et_phone, 11));
    }

    private class HideTextWatcher implements TextWatcher{
        private EditText mView;
        private int mMaxLength;
        public HideTextWatcher(EditText v, int mMaxLength){
            super();
            mView = v;
            mMaxLength = mMaxLength;
        }
        public void beforeTextChanged(CharSequence s, int start, int count, int after){}

        public void onTextChanged(CharSequence s, int start, int before, int count){}

        public void afterTextChanged(Editable s){
            String str = s.toString();
            if((str.length() == 11 && mMaxLength == 11) || (str.length() ==6 && mMaxLength ==6)){
                ViewUtil.hideOneInputMethod(LoginSQLiteActivity.this, mView );
            }
        }
    }

    @Override
    public void onClick(View v) {
        String phone = et_phone.getText().toString();
        if (v.getId() == R.id.btn_forget) { // 点击了“忘记密码”按钮
            if (phone.length() < 11) { // 手机号码不足11位
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            if (rb_password.isChecked()) { // 选择了密码方式校验，此时要跳到找回密码页面
                // 以下携带手机号码跳转到找回密码页面
                Intent intent = new Intent(this, LoginForgetActivity.class);
                intent.putExtra("phone", phone);
                startActivityForResult(intent, mRequestCode); // 携带意图返回上一个页面
            } else if (rb_verifycode.isChecked()) { // 选择了验证码方式校验，此时要生成六位随机数字验证码
                // 生成六位随机数字的验证码
                mVerifyCode = String.format("%06d", new Random().nextInt(999999));
                // 以下弹出提醒对话框，提示用户记住六位验证码数字
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("请记住验证码");
                builder.setMessage("手机号" + phone + "，本次验证码是" + mVerifyCode + "，请输入验证码");
                builder.setPositiveButton("好的", null);
                AlertDialog alert = builder.create();
                alert.show(); // 显示提醒对话框
            }
        } else if (v.getId() == R.id.btn_login) { // 点击了“登录”按钮
            if (phone.length() < 11) { // 手机号码不足11位
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            if (rb_password.isChecked()) { // 密码方式校验
                if (!et_password.getText().toString().equals(mPassword)) {
                    Toast.makeText(this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                } else { // 密码校验通过
                    loginSuccess(); // 提示用户登录成功
                }
            } else if (rb_verifycode.isChecked()) { // 验证码方式校验
                if (!et_password.getText().toString().equals(mVerifyCode)) {
                    Toast.makeText(this, "请输入正确的验证码", Toast.LENGTH_SHORT).show();
                } else { // 验证码校验通过
                    loginSuccess(); // 提示用户登录成功
                }
            }
        }
    }

    private void loginSuccess(){
        String desc = String.format("您的手机号码是%s，恭喜你通过登录验证，点击“确定”按钮返回上个页面", et_phone.getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录成功");
        builder.setMessage(desc);
        builder.setPositiveButton("确定返回", (dialog, which) -> finish());
        builder.setNegativeButton("我在看看", null);
        AlertDialog alert = builder.create();
        alert.show();
        if(isRemember){
            UserInfo info = new UserInfo();
            info.phone = et_phone.getText().toString();
            info.password = et_password.getText().toString();
            info.update_time = DateUtil.getNowDateTime("yy-MM-dd HH:mm:ss");
            mHelper.insert(info);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        mHelper = UserDBHelper.getInstance(this, 1); // 获得用户数据库帮助器的实例
        mHelper.openWriteLink(); // 恢复页面，则打开数据库连接
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHelper.closeLink(); // 暂停页面，则关闭数据库连接
    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }

    private class RadioListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.rb_password){
                tv_password.setText("登录密码：");
                et_password.setHint("请输入密码");
                btn_forget.setText("忘记密码");
                ck_remember.setVisibility(View.VISIBLE);
            }else if(checkedId == R.id.rb_verifycode){
                tv_password.setText("  验证码：");
                et_password.setHint("请输入验证码");
                btn_forget.setText("获取验证码");
                ck_remember.setVisibility(View.GONE);
            }
        }
    }

}
