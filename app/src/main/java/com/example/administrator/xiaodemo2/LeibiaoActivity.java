package com.example.administrator.xiaodemo2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.administrator.xiaodemo2.clazz.Tab;
import com.example.administrator.xiaodemo2.fragment.LeiFragment;
import com.example.administrator.xiaodemo2.fragment.ShouFragment;

import java.util.ArrayList;
import java.util.List;

public class LeibiaoActivity extends AppCompatActivity {

    private FrameLayout realcontent;
    private FragmentTabHost tabhost;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leibiao);
        initView();
        initData();
    }

    private void initData() {
        Tab lei = new Tab("列表", LeiFragment.class);
        Tab shou = new Tab("收藏", ShouFragment.class);

        List<Tab> fragmentList=new ArrayList<>();
        fragmentList.add(lei);
        fragmentList.add(shou);


        tabhost.setup(this,getSupportFragmentManager(),R.id.realcontent);
        inflater = LayoutInflater.from(this);


        for(Tab tab:fragmentList){
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(tab.getText());
            tabSpec.setIndicator(MyView(tab));
            tabhost.addTab(tabSpec,tab.getFragment(),null);
        }
    }
    public View MyView(Tab tab){
        View view = LayoutInflater.from(LeibiaoActivity.this).inflate(R.layout.iten, null);
        TextView text = view.findViewById(R.id.tab_textview);


        text.setText(tab.getText());

        return view;
    }

    private void initView() {
        realcontent = (FrameLayout) findViewById(R.id.realcontent);
        tabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    }
}
