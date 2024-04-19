package com.bailitop.chapter06;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class ShareReadActivity  extends AppCompatActivity {
    private TextView tv_share;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_read);
        tv_share = findViewById(R.id.tv_share);
        readSharedPreferences();
    }

    private void readSharedPreferences(){
        SharedPreferences shared = getSharedPreferences("share", MODE_PRIVATE);
        String desc = "共享參數中的保存的信息如下：";
        Map<String, Object> mapParam = (Map<String, Object>) shared.getAll();
        for (Map.Entry<String, Object> item_map : mapParam.entrySet()) {
            String key = item_map.getKey(); // 获取该配对的键信息
            Object value = item_map.getValue(); // 获取该配对的值信息
            if (value instanceof String) { // 如果配对值的类型为字符串
                desc = String.format("%s\n　%s的取值为%s", desc, key,shared.getString(key, ""));
            } else if (value instanceof Integer) { // 如果配对值的类型为整型数
                desc = String.format("%s\n　%s的取值为%d", desc, key, shared.getInt(key, 0));
            } else if (value instanceof Float) { // 如果配对值的类型为浮点数
                desc = String.format("%s\n　%s的取值为%f", desc, key, shared.getFloat(key, 0.0f));
            } else if (value instanceof Boolean) { // 如果配对值的类型为布尔值
                desc = String.format("%s\n　%s的取值为%b", desc, key,shared.getBoolean(key, false));
            } else if (value instanceof Long) { // 如果配对值的类型为长整型
                desc = String.format("%s\n　%s的取值为%d", desc, key, shared.getLong(key, 0L));
            } else { // 如果配对值的类型为未知类型
                desc = String.format("%s\n参数%s的取值为未知类型", desc, key);
            }
        }

        if(mapParam.size() <=0){
            desc = "共享參數中保存的數據信息為空";
        }
        tv_share.setText(desc);
    }
}
