package com.bailitop.study5.chapter05;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.R;

import java.util.Calendar;

public class datePickerActivity  extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private DatePicker dp_date;
    private TextView tv_date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        tv_date = findViewById(R.id.tv_date);
        findViewById(R.id.btn_date).setOnClickListener(this);
        findViewById(R.id.btn_ok).setOnClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String desc = String.format("您选择的日期是%d年%d月%d日", year, monthOfYear, dayOfMonth);
        tv_date.setText(desc);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_date){
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog dialog = new DatePickerDialog(this,this,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            dialog.show();
        } else if (v.getId() == R.id.btn_ok) {
            String desc  = String.format("您选择的日期是%d年%d月%d日",
                    dp_date.getYear(),
                    dp_date.getMonth()+1,
                    dp_date.getDayOfMonth());
            tv_date.setText(desc);
        }
    }


}
