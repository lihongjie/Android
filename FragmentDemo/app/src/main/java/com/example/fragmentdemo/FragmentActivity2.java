package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FragmentActivity2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;

    //Fragment Object
    private MyFragment fg1, fg2, fg3, fg4;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment2);
        fManager = getFragmentManager();
        rg_tab_bar = findViewById(R.id.rg_tab_bar2);
        rg_tab_bar.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态
        rb_channel = findViewById(R.id.rb_channel2);
        rb_channel.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (checkedId) {
            case R.id.rb_channel2:
                if (fg1 == null) {
                    fg1 = new MyFragment("第一个Fragment");
                    fTransaction.add(R.id.ly_content2, fg1);
                } else {
                    fTransaction.show(fg1);
                }
                break;
            case R.id.rb_message2:
                if (fg2 == null) {
                    fg2 = new MyFragment("第二个Fragment");
                    fTransaction.add(R.id.ly_content2, fg2);
                } else {
                    fTransaction.show(fg2);
                }
                break;
            case R.id.rb_better2:
                if (fg3 == null) {
                    fg3 = new MyFragment("第三个Fragment");
                    fTransaction.add(R.id.ly_content2, fg3);
                } else {
                    fTransaction.show(fg3);
                }
                break;
            case R.id.rb_setting2:
                if (fg4 == null) {
                    fg4 = new MyFragment("第四个Fragment");
                    fTransaction.add(R.id.ly_content2, fg4);
                } else {
                    fTransaction.show(fg4);
                }
                break;
        }
        fTransaction.commit();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);
        if (fg4 != null) fragmentTransaction.hide(fg4);
    }
}