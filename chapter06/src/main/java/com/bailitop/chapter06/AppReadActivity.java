package com.bailitop.chapter06;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class AppReadActivity extends AppCompatActivity {
    private TextView tv_app;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_read);
        tv_app = findViewById(R.id.tv_app);
        readAppMemory();
    }

    private void readAppMemory() {
        String desc = "全局内存中的保存的信息如下：";
        MainApplication app = MainApplication.getInstance();
        Map<String, String> mapParam = app.infoMap;
        for (Map.Entry<String, String> item_map : mapParam.entrySet()) {
            desc = String.format("%s\n　%s的取值为%s", desc, item_map.getKey(), item_map.getValue());
        }
        if (mapParam.size() <= 0) { 
            desc = "全局内存中保存的信息为空";
        }
        tv_app.setText(desc);
    }
}
