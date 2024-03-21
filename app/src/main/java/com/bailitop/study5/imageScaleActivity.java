package com.bailitop.study5;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class imageScaleActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scale);
        ImageView iv_scale = findViewById(R.id.iv_scale);
        iv_scale.setImageResource(R.drawable.apple);
        iv_scale.setScaleType(ImageView.ScaleType.CENTER);
    }
}