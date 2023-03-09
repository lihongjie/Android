package com.example.activitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        //注册按钮
        Button btnregister = (Button) findViewById(R.id.btnregister);
        EditText editname = (EditText) findViewById(R.id.editname);
        RadioGroup rad = (RadioGroup) findViewById(R.id.radioGroup);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, sex = "";
                Intent it = new Intent(MainActivity.this, MainActivity3.class);

                name = editname.getText().toString();

                //遍历RadioGroup找出被选中的单选按钮
                for (int i = 0; i < rad.getChildCount(); i++) {
                    RadioButton rd = (RadioButton) rad.getChildAt(i);
                    if (rd.isChecked()) {
                        sex = rd.getText().toString();
                        break;
                    }
                }

                //新建Bundle对象,并把数据写入
                Bundle bd = new Bundle();
                bd.putCharSequence("user", name);
                bd.putCharSequence("sex", sex);

                //将数据包Bundle绑定到Intent上
                it.putExtras(bd);
                startActivity(it);
                //关闭第一个Activity
                finish();

            }
        });
    }
}