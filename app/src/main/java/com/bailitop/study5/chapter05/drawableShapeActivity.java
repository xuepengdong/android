package com.bailitop.study5.chapter05;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.R;

public class drawableShapeActivity extends AppCompatActivity implements View.OnClickListener {
    private  View v_content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_shape);
        v_content = findViewById(R.id.v_content);
        v_content.setBackgroundResource(R.drawable.shape_react_gold);
        findViewById(R.id.btn_rect).setOnClickListener(this);
        findViewById(R.id.btn_oval).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_rect){
            v_content.setBackgroundResource(R.drawable.shape_react_gold);
        } else if (v.getId() == R.id.btn_oval) {
            v_content.setBackgroundResource(R.drawable.shape_oval_rose);
        }
    }
}
