package com.example.activitydemo.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.activitydemo.R;

public class CustomDialog extends AlertDialog {
    //显示的标题，消息，按钮
    private TextView titleTv;
    private TextView messageTv;
    private Button negtiveBn, positiveBn;

    //显示的消息
    public CustomDialog(Context context) {
        super(context);
    }

    private String message;
    private String title;
    private String positive, negtive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        initView();
        initEvent();
    }

    //初始化页面控件
    private void initView() {
        negtiveBn = findViewById(R.id.negtive);
        positiveBn = findViewById(R.id.positive);
        titleTv = findViewById(R.id.title);
        messageTv = findViewById(R.id.message);
    }

    //初始化页面控件的显示数据
    private void refreshView() {
        //如果自定义了title和message的信息，则会在弹出框中显示
        if (!TextUtils.isEmpty(title)) {
            //设置标题控件的文本为自定义的title
            titleTv.setText(title);
            //标题控件设置为显示状态
            titleTv.setVisibility(View.VISIBLE);
        } else {
            //否则标题控件设置为隐藏状态
            titleTv.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(message)) {
            //设置标题控件的文本为自定义的message
            messageTv.setText(message);
        }
        //如果没有自定义按钮的文本，则默认显示“确认”和“取消”
        if (!TextUtils.isEmpty(positive)) {
            //设置按钮控件的文本为自定义文本
            positiveBn.setText(positive);
        } else {
            positiveBn.setText("确定");
        }
        if (!TextUtils.isEmpty(negtive)) {
            //设置按钮控件的文本为自定义文本
            negtiveBn.setText(negtive);
        } else {
            negtiveBn.setText("取消");
        }
    }

    //初始化界面的确定和取消的监听器
    private void initEvent() {
        //设置“确定”按钮的点击事件的监听器
        positiveBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickBottomListener != null) {
                    onClickBottomListener.onPositiveClick();
                }
            }
        });
        negtiveBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickBottomListener != null) {
                    onClickBottomListener.onNegtiveClick();
                }
            }
        });
    }

    @Override
    public void show() {
        super.show();
        refreshView();
    }

    public interface OnClickBottomListener {
        void onPositiveClick();
        void onNegtiveClick();
    }

    //设置“确定”和“取消”按钮的回调
    public OnClickBottomListener onClickBottomListener;

    public CustomDialog setOnClickBottomListener(OnClickBottomListener onClickBottomListener) {
        this.onClickBottomListener = onClickBottomListener;
        return this;
    }

    public CustomDialog setAll(String message, String title, String negtive, String positive) {
        this.message = message;
        this.title = title;
        this.negtive = negtive;
        this.positive = positive;
        return this;
    }
}