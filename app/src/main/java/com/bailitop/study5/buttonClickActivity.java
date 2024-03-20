package com.bailitop.study5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class buttonClickActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_result; // 声明一个文本视图实例


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);
        tv_result = findViewById(R.id.tv_result); // 获取名叫tv_result的文本视图
        // 从布局文件中获取名叫btn_click_single的按钮控件
        Button btn_click_single = findViewById(R.id.btn_click_single);
        // 设置点击监听器，一旦用户点击按钮，就触发监听器的onClick方法
        btn_click_single.setOnClickListener(new MyOnClickListener());
        // 从布局文件中获取名叫btn_click_public的按钮控件
        Button btn_click_public = findViewById(R.id.btn_click_public);
        // 设置点击监听器，一旦用户点击按钮，就触发监听器的onClick方法
        btn_click_public.setOnClickListener(this);
    }

    // 定义一个点击监听器，它实现了接口View.OnClickListener
    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) { // 点击事件的处理方法
            Object DateUtil;
            DateUtil = null;
            String desc = String.format("%s 您点击了按钮：%s",
                    getNowTime(), ((Button) v).getText());
            tv_result.setText(desc); // 设置文本视图的文本内容
        }
    }

    // 自定义方法用于获取当前时间的字符串表示
    private String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    @Override
    public void onClick(View v) { // 点击事件的处理方法
        if (v.getId() == R.id.btn_click_public) { // 来自按钮btn_click_public
            String desc = String.format("%s 您点击了按钮：%s",
                    getNowTime(), ((Button) v).getText());
            tv_result.setText(desc); // 设置文本视图的文本内容
        }
    }

}