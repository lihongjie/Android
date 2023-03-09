package com.example.activitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置文本
        TextView tv = findViewById(R.id.tv);
        tv.setText("你好，世界");

        Button button = findViewById(R.id.button);

        //实现按钮的点击事件
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        Button btn1 = findViewById(R.id.btn1);

        //实现按钮的点击事件
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        Button btn2 = findViewById(R.id.btn2);

        //实现按钮的点击事件
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        Button btn3 = findViewById(R.id.btn3);

        //实现按钮的点击事件
        btn3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
        Button btn4 = findViewById(R.id.btn4);

        //实现按钮的点击事件
        btn4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

        //实现按钮的点击事件-scrollview
        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ScrollViewActivity.class);
                startActivity(intent);
            }
        });

        //实现按钮的点击事件-scrollview
        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ScrollViewActivity1.class);
                startActivity(intent);
            }
        });

    }
}