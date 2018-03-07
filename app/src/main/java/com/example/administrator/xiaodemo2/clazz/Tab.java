package com.example.administrator.xiaodemo2.clazz;

/**
 * Created by Administrator on 2018/3/6.
 */

public class Tab {

    private String Text;
    private Class Fragment;

    public Tab(String text, Class fragment) {
        Text = text;
        Fragment = fragment;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Class getFragment() {
        return Fragment;
    }

    public void setFragment(Class fragment) {
        Fragment = fragment;
    }
}
