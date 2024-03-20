package com.bailitop.study5;

import android.os.Bundle;
import android.text.format.DateUtils; // 导入正确的DateUtils类
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat; // 导入用于格式化日期的类
import java.util.Date; // 导入Date类
import java.util.Locale; // 导入Locale类用于设置日期格式的语言环境

public class buttonStyleActivity extends AppCompatActivity {
    private TextView tv_result; // 声明一个文本视图实例

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_style);
        tv_result = findViewById(R.id.tv_result); // 获取名叫tv_result的文本视图
    }

    // 自定义方法用于获取当前时间的字符串表示
    private String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    // activity_button_style.xml中给btn_click_xml指定了点击方法doClick
    public void doClick(View view) {
        String desc = String.format("%s 您点击了按钮：%s",
                getNowTime(), ((Button) view).getText()); // 使用自定义的getNowTime方法
        tv_result.setText(desc); // 设置文本视图的文本内容
    }
}