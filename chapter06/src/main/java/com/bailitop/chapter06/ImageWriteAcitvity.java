package com.bailitop.chapter06;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;

import util.DateUtil;
import util.FileUtil;
import util.ToastUtil;


public class ImageWriteAcitvity extends AppCompatActivity implements View.OnClickListener {
    private Button button_save;
    private TextView tv_path;
    private ImageView iv_content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_write);
        iv_content =  findViewById(R.id.iv_content);
        iv_content.setImageResource(R.drawable.huawei);
        tv_path = findViewById(R.id.tv_path);
        findViewById(R.id.btn_save).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_save){
            String path = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() +"/";
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.huawei);
            String file_paty =  path+ DateUtil.getNowDateTime("") + ".jpeg";
            FileUtil.saveImage(file_paty, bitmap);
            tv_path.setText("图片保存路径:\n" + file_paty);
            ToastUtil.show(this, "图片已经写入存储卡文件");
        }
    }
}
