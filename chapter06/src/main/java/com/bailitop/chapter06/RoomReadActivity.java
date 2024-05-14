package com.bailitop.chapter06;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import entity.BookInfo;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

import dao.BookDao;
import util.ToastUtil;

public class RoomReadActivity  extends AppCompatActivity  implements View.OnClickListener {
    private Button tv_room;
    private BookDao bookDao;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_room_read);
        tv_room = findViewById(R.id.tv_room);
        bookDao = MainApplication.getInstance().getBookDB().bookDao();
    }

    public void readRoom(){
        List<BookInfo> bookList = bookDao.queryAllBook(); // 确保类名是BookInfo
        StringBuilder desc = new StringBuilder(); // 使用StringBuilder
        desc.append("数据库查询到").append(bookList.size()).append("条记录，详情如下\n");
        for(int i = 0; i < bookList.size(); i++){
            BookInfo info = bookList.get(i);
            desc.append("\n第").append(i + 1).append("条记录信息如下：\n");
            desc.append("　书名为《").append(info.getName()).append("》\n");
            desc.append("　作者为").append(info.getAuthor()).append("\n");
            desc.append("　出版社为").append(info.getPress()).append("\n");
            desc.append("　价格为").append(info.getPrice()).append("\n");
        }
        if(bookList.isEmpty()){ // 简化检查，使用isEmpty()方法
            desc.setLength(0); // 清空之前的内容
            desc.append("数据查询的记录为空");
        }
        tv_room.setText(desc.toString()); // 使用toString()方法获取最终的字符串
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_delete){
            bookDao.deleteAllBook();
            ToastUtil.show(this, "已经删除图书数据库所有的数据");
            readRoom();
        }
    }
}
