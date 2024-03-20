package com.bailitop.study5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 當前得頁面佈局採用的是res/layout/activity_main.xml
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "看到你了");
        //獲取名為tv_hello的TextView的控件，注意添加導包語句
        TextView tv_hello = findViewById(R.id.tv_hello);
        // 設置textView控件得文字內容
        tv_hello.setText("前端部");

        Button myButton = findViewById(R.id.mybutton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewBorderActivity.class);
                startActivity(intent);
            }
        });


        Button activity_linear_layout = findViewById(R.id.activity_linear_layout);
        activity_linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, linearLayoutActivity.class);
                startActivity(intent);
            }
        });



        Button activity_relative_layout = findViewById(R.id.activity_relative_layout);
        activity_relative_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,activity_relative_layout.class);
                startActivity(intent);
            }
        });


        Button activity_grid_layout = findViewById(R.id.activity_grid_layout);
        activity_grid_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,gridLayoutActivity.class);
                startActivity(intent);
            }
        });

        Button scrollLayoutActivity = findViewById(R.id.scrollLayoutActivity);
        scrollLayoutActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,scrollLayoutActivity.class);
                startActivity(intent);
            }
        });

        Button activity_button_style = findViewById(R.id.activity_button_style);
        activity_button_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,buttonStyleActivity.class);
                startActivity(intent);
            }
        });

        Button activity_button_click = findViewById(R.id.activity_button_click);
        activity_button_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,buttonClickActivity.class);
                startActivity(intent);
            }
        });


        Button activity_button_longclick = findViewById(R.id.activity_button_longclick);
        activity_button_longclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,buttonLongclickActivity.class);
                startActivity(intent);
            }
        });



    }

    protected void onResume(){
        super.onResume();
        goNextPage();//跳转到下一个页面
    }

    private void goNextPage(){
        TextView tv_hello = findViewById(R.id.tv_hello);
//        tv_hello.setText("3秒後進入下一個頁面");
        //延遲三秒
//        new Handler().postDelayed(mGoNext, 3000);

    }

    private Runnable mGoNext = new Runnable() {
        @Override
        public void run() {
            //活動頁面跳轉，從MainActivity跳轉到Main2Activity
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }
    };
}