package com.bailitop.chapter06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button ShareWriteActivity = findViewById(R.id.ShareWriteActivity);
        ShareWriteActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShareWriteActivity.class);
                startActivity(intent);
            }
        });

        Button ShareReadActivity = findViewById(R.id.ShareReadActivity);
        ShareReadActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShareReadActivity.class);
                startActivity(intent);
            }
        });
    }
}