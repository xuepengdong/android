package com.bailitop.study5.chapter05;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.R;

public class checkBoxActivity extends AppCompatActivity  implements CompoundButton.OnCheckedChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        CheckBox ck_system = findViewById(R.id.ck_system);
        CheckBox ck_custom = findViewById(R.id.ck_custom);
        ck_system.setOnCheckedChangeListener(this);
        ck_custom.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String desc = String.format("您%s了这个CheckBox", isChecked ? "勾选" : "取消勾选");
        buttonView.setText(desc);
        Log.d("您%s了这个CheckBox", isChecked ? "勾选" : "取消勾选");
    }

    // 定义一个勾选监听器，它实现了接口CompoundButton.OnCheckedChangeListener
    private class CheckListener implements CompoundButton.OnCheckedChangeListener{
        // 在用户点击复选框时触发
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String desc = String.format("您勾选了控件%d，状态为%b", buttonView.getId(), isChecked);
            Toast.makeText(checkBoxActivity.this, desc, Toast.LENGTH_LONG).show();
        }
    }
}
