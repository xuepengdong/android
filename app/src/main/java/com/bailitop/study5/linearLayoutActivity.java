package com.bailitop.study5;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.util.Utils;

public class linearLayoutActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
//        TextView tv_code = findViewById(R.id.tv_code);
//        ViewGroup.LayoutParams params = tv_code.getLayoutParams();
//        params.width = Utils.dip2px(this, 300);
//        tv_code.setLayoutParams(params);
    }
}
