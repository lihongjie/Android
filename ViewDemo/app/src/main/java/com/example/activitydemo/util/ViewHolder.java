package com.example.activitydemo.util;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

    public TextView title;
    public TextView price;
    public ImageView iv;

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }

    public TextView getPrice() {
        return price;
    }

    public void setPrice(TextView price) {
        this.price = price;
    }
}
