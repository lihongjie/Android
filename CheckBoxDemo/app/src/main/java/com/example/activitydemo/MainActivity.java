package com.example.activitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private TextView hobby;
    private TextView count;

    //用来存放选中的CheckBox信息
    private List<String> hobbyList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化CheckBox控件
        CheckBox basketball = findViewById(R.id.like_basketball);
        CheckBox swim = findViewById(R.id.like_swim);
        CheckBox code = findViewById(R.id.like_code);
        CheckBox dance = findViewById(R.id.like_dance);

        basketball.setOnCheckedChangeListener(this);
        swim.setOnCheckedChangeListener(this);
        code.setOnCheckedChangeListener(this);
        dance.setOnCheckedChangeListener(this);

        hobby = findViewById(R.id.like_hobby);
        count = findViewById(R.id.selected_count);
        count.setText(String.valueOf(hobbyList.size()));

        Button button = findViewById(R.id.button_toast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "WIFI连接已断开", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        String motion = buttonView.getText().toString();
        Log.i("当前为: ", motion);
        Log.i("状态为: ", String.valueOf(isChecked));
        if (!hobbyList.contains(motion)) {
            hobbyList.add(motion);
            hobby.setText(hobbyList.toString());
            count.setText(String.valueOf(hobbyList.size()));
        } else {
            hobbyList.remove(motion);
            hobby.setText(hobbyList.toString());
            count.setText(String.valueOf(hobbyList.size()));
        }
    }
}