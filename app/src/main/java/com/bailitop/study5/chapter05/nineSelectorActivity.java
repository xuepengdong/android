package com.bailitop.study5.chapter05;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.R;

public class nineSelectorActivity  extends AppCompatActivity implements View.OnClickListener {
    private View v_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_nine_select);
        v_content = findViewById(R.id.v_content);
        findViewById(R.id.btn_rect).setOnClickListener(this);
        findViewById(R.id.btn_oval).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_rect) {
            v_content.setBackgroundResource(R.drawable.btn_nine_selector);
        } else if (v.getId() == R.id.btn_oval) {
            v_content.setBackgroundResource(R.drawable.button_normal);
        }
    }
}
