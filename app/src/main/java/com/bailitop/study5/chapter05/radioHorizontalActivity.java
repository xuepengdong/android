package com.bailitop.study5.chapter05;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.R;

    public class radioHorizontalActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
        private TextView tv_sex;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_horizontal);
        tv_sex = findViewById(R.id.tv_sex);
        RadioGroup rg_sex = findViewById(R.id.rg_sex);
        rg_sex.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.rb_male){
            tv_sex.setText("this is a boy");
        }else{
            tv_sex.setText("this is a girl");
        }
    }

    class RadioListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Toast.makeText(radioHorizontalActivity.this, "您选中了控件" + checkedId, Toast.LENGTH_LONG).show();
        }
    }
}
