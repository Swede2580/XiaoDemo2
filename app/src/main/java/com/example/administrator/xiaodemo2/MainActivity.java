package com.example.administrator.xiaodemo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt;
    private Button but;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.set);

        img.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this,LeibiaoActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void initView() {
        txt = (TextView) findViewById(R.id.txt);
        but = (Button) findViewById(R.id.but);
        img = (ImageView) findViewById(R.id.img);

        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:
                startActivity(new Intent(MainActivity.this,LeibiaoActivity.class));
                finish();
                break;
        }
    }
}
