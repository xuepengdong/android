package com.bailitop.chapter06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import util.PermissionUtil;

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

        Button LoginShareActivity = findViewById(R.id.LoginShareActivity);
        LoginShareActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginShareActivity.class);
                startActivity(intent);
            }
        });

        Button DatastroeWriteActivity = findViewById(R.id.DatastroeWriteActivity);
        DatastroeWriteActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatastroeWriteActivity.class);
                startActivity(intent);
            }
        });
        Button DatastoreReadActivity = findViewById(R.id.DatastoreReadActivity);
        DatastoreReadActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatastoreReadActivity.class);
                startActivity(intent);
            }
        });

        Button DatabaseActivity = findViewById(R.id.DatabaseActivity);
        DatabaseActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
                startActivity(intent);
            }
        });

        Button SQLiteWriteActivity = findViewById(R.id.SQLiteWriteActivity);
        SQLiteWriteActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SQLiteWriteActivity.class);
                startActivity(intent);
            }
        });

        Button SQLiteReadActivity = findViewById(R.id.SQLiteReadActivity);
        SQLiteReadActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SQLiteReadActivity.class);
                startActivity(intent);
            }
        });

        Button LoginSQLiteActivity = findViewById(R.id.LoginSQLiteActivity);
        LoginSQLiteActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginSQLiteActivity.class);
                startActivity(intent);
            }
        });

        Button FilePathActivity = findViewById(R.id.FilePathActivity);
        FilePathActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilePathActivity.class);
                startActivity(intent);
            }
        });
        Button ImageWriteAcitvity = findViewById(R.id.ImageWriteAcitvity);
        ImageWriteAcitvity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageWriteAcitvity.class);
                startActivity(intent);
            }
        });

        Button FileWriteActivity = findViewById(R.id.FileWriteActivity);
        FileWriteActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FileWriteActivity.class);
                startActivity(intent);
            }
        });

        Button AppWriteActivity = findViewById(R.id.AppWriteActivity);
        AppWriteActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppWriteActivity.class);
                startActivity(intent);
            }
        });

        Button AppReadActivity = findViewById(R.id.AppReadActivity);
        AppReadActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppReadActivity.class);
                startActivity(intent);
            }
        });

        Button MainActivity = findViewById(R.id.MainActivity);
        MainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppReadActivity.class);
                startActivity(intent);
            }
        });

        Button RoomReadActivity = findViewById(R.id.RoomReadActivity);
        RoomReadActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoomReadActivity.class);
                startActivity(intent);
            }
        });

        Button ContentWriteActivity = findViewById(R.id.ContentWriteActivity);
        ContentWriteActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContentWriteActivity.class);
                startActivity(intent);
            }
        });

    }
}