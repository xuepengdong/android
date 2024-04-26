package com.bailitop.chapter06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


    }
}