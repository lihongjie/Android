package com.example.activitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.activitydemo.util.ViewHolder;

public class ListViewActivity extends AppCompatActivity {

    //生物与价格数据集合
    private String[] titles = {"豹猫", "毪菇", "马", "狼"};
    private String[] prices = {"1000", "4000", "6577", "5000"};
    //图片数据集合
    private int[] icons = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //初始化ListView控件
        ListView mListView = (ListView) findViewById(R.id.list_view);
        //创建一个数据适配器实例
        MyBaseAdapter ma = new MyBaseAdapter();
        mListView.setAdapter(ma);
    }

    //编写一个实现了BaseAdapter抽象类的数据适配器类
    class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            //获取Item的总数
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            //返回Item的数据对象
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            //返回item的id
            return position;
        }

        //得到item的视图
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            View view = View.inflate(ListViewActivity.this, R.layout.list_item, null);
//            TextView title = (TextView) view.findViewById(R.id.title);
//            TextView price = (TextView) view.findViewById(R.id.price);
//            ImageView iv = (ImageView) view.findViewById(R.id.iv);
//            title.setText(titles[position]);
//            price.setText(prices[position]);
//            iv.setBackgroundResource(icons[position]);
//            return view;
//        }

        //优化view
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                //将list_item.xml布局文件找出来并转换为View对象
                convertView = View.inflate(ListViewActivity.this,R.layout.list_item,null);
                //找到activity_item.xml中的TextView
                holder = new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.price = (TextView) convertView.findViewById(R.id.price);
                holder.iv = (ImageView) convertView.findViewById(R.id.iv);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(titles[position]);
            holder.price.setText(prices[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return convertView;
        }

    }
}