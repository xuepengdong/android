package com.bailitop.study5.chapter05;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bailitop.study5.R;

public class alertDialogActivity  extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_alert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_alert_dialog);
         findViewById(R.id.btn_alert).setOnClickListener(this);
         tv_alert = findViewById(R.id.tv_alert);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_alert){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("尊敬的用户");
            builder.setMessage("你真的要卸载我吗？");

            builder.setPositiveButton("残忍卸载", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    tv_alert.setText("虽然依依不舍，但是只能离开了");
                }
            });

            builder.setNegativeButton("我再想想", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    tv_alert.setText("让我陪你三百六十五个日夜");
                }
            });

            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
