package com.bailitop.chapter06;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import bean.UserInfo;
import provider.UserInfoContent;
import util.ToastUtil;
import util.Utils;

public class ContentReadActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout ll_list;
    private TextView tv_desc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_read);
        ll_list = findViewById(R.id.ll_list);
        tv_desc = findViewById(R.id.tv_desc);
        showAllUser();
    }

    @SuppressLint("Range")
    private void showAllUser(){
        List<UserInfo> userList = new ArrayList<UserInfo>();
        Cursor cursor = getContentResolver().query(UserInfoContent.CONTENT_URI, null, null, null,null);
        while (cursor.moveToNext()){
            UserInfo user = new UserInfo();
            user.name = cursor.getString(cursor.getColumnIndex(UserInfoContent.USER_NAME));
            user.age = cursor.getInt(cursor.getColumnIndex(UserInfoContent.USER_AGE));
            user.height = cursor.getInt(cursor.getColumnIndex(UserInfoContent.USER_HEIGHT));
            user.weight = cursor.getFloat(cursor.getColumnIndex(UserInfoContent.USER_WEIGHT));
            userList.add(user);
        }
        cursor.close();
        String contactCount = String.format("当前共找到%d个用户", userList.size());
        tv_desc.setText(contactCount);
        ll_list.removeAllViews();//移除线性布局下面的所有下级视图
        for(UserInfo user : userList){
            String contactDesc = String.format("姓名为%s, 年龄为%d, 身高为d%, 体重为%f\n", user.name, user.age, user.height, user.weight);
            TextView tv_contact = new TextView(this);
            tv_contact.setText(contactDesc);
            tv_contact.setTextColor(Color.BLACK);
            tv_contact.setTextSize(17);
            int pad = Utils.dip2px(this, 5);
            tv_contact.setPadding(pad, pad, pad, pad);
            ll_list.addView(tv_contact);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==  R.id.btn_delete){
            getContentResolver().delete(UserInfoContent.CONTENT_URI, "1=1", null);
            showAllUser();
            ToastUtil.show(this, "已删除所有记录");
        }
    }
}
