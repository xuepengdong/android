package com.bailitop.study5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        Button activity_button_enable = findViewById(R.id.activity_button_enable);
        activity_button_enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,buttonEnableActivity.class);
                startActivity(intent);
            }
        });


        Button activity_image_scale = findViewById(R.id.activity_image_scale);
        activity_image_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,imageScaleActivity.class);
                startActivity(intent);
            }
        });

        Button activity_image_button = findViewById(R.id.activity_image_button);
        activity_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,imageButtonActivity.class);
                startActivity(intent);
            }
        });

        Button activity_image_text = findViewById(R.id.activity_image_text);
        activity_image_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,imageTextActivity.class);
                startActivity(intent);
            }
        });

        Button activity_act_finish = findViewById(R.id.activity_act_finish);
        activity_act_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,actFinishActivity.class);
                startActivity(intent);
            }
        });


        Button activity_act_life = findViewById(R.id.activity_act_life);
        activity_act_life.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, actLifeActivity.class);
                startActivity(intent);
            }
        });

        Button activity_first_activity = findViewById(R.id.activity_first_activity);
        activity_first_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, jumpFirstActivity.class);
                startActivity(intent);
            }
        });


        Button activity_login_input = findViewById(R.id.activity_login_input);
        activity_login_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, loginInputActivity.class);
                startActivity(intent);
            }
        });

        Button activity_action_uri = findViewById(R.id.activity_action_uri);
        activity_action_uri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, actionUriActivity.class);
                startActivity(intent);
            }
        });

        Button actSendActivity = findViewById(R.id.actSendActivity);
        actSendActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, actSendActivity.class);
                startActivity(intent);
            }
        });

        Button actRequestActivity = findViewById(R.id.actRequestActivity);
        actRequestActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, actRequestActivity.class);
                startActivity(intent);
            }
        });

        Button choosePhotoActivity = findViewById(R.id.choosePhotoActivity);
        choosePhotoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, choosePhotoActivity.class);
                startActivity(intent);
            }
        });

        Button broadStandardActivity = findViewById(R.id.broadStandardActivity);
        broadStandardActivity.setOnClickListener(new View.OnClickListener() {ss
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, broadStandardActivity.class);
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