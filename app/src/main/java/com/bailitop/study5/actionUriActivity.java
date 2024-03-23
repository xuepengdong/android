package com.bailitop.study5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class actionUriActivity extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_uri);
        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String phoneNo = "13720095654";
        Intent intent = new Intent();

        if(v.getId() == R.id.btn_dial){
            intent.setAction(Intent.ACTION_DIAL);
            Uri uri = Uri.parse("tel:" + phoneNo);
            intent.setData(uri);
            startActivity(intent);
        }else{
            intent.setAction(Intent.ACTION_SENDTO);
            Uri uri = Uri.parse("smsto:" + phoneNo);
            intent.setData(uri);
            startActivity(intent);
        }
    }
}
