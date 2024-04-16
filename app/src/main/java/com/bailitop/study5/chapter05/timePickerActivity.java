package com.bailitop.study5.chapter05;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.R;

import java.util.Calendar;

public class timePickerActivity  extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {
    private TextView tv_time;
    private TimePicker tp_time; // 声明一个时间选择器对象


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        tv_time = findViewById(R.id.tv_time);
        tp_time = findViewById(R.id.tp_time);
        findViewById(R.id.btn_time).setOnClickListener(this);
        findViewById(R.id.btn_ok).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_time) {
            // 获取日历的一个实例，里面包含了当前的时分秒
            Calendar calendar = Calendar.getInstance();
            // 构建一个时间对话框，该对话框已经集成了时间选择器。
            // TimePickerDialog的第二个构造参数指定了时间监听器
            TimePickerDialog dialog = new TimePickerDialog(this, this,
                    calendar.get(Calendar.HOUR_OF_DAY), // 小时
                    calendar.get(Calendar.MINUTE), // 分钟
                    true); // true表示24小时制，false表示12小时制
            dialog.show(); // 显示时间对话框
        } else if (v.getId() == R.id.btn_ok) {
            // 获取时间选择器tp_time设定的小时和分钟
            String desc = String.format("您选择的时间是%d时%d分",
                    tp_time.getCurrentHour(), tp_time.getCurrentMinute());
            tv_time.setText(desc);
        }
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        String desc = String.format("您选择时间爱你是%d时%d分", hourOfDay, minute);
        tv_time.setText(desc);
    }
}
