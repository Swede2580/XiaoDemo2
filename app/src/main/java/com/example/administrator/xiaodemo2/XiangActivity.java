package com.example.administrator.xiaodemo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class XiangActivity extends AppCompatActivity {

    private ImageView img;
    private TextView name;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        initView();
        iniData();
    }

    private void iniData() {
        String namev = getIntent().getStringExtra("name");
        String imgv = getIntent().getStringExtra("img");
        String contentv = getIntent().getStringExtra("content");


        Picasso.with(this).load(imgv).into(img);
        name.setText(namev);
        content.setText(contentv);
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        content = (TextView) findViewById(R.id.content);
    }
}
