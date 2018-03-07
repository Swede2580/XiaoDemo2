package com.example.administrator.xiaodemo2;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.xiaodemo2.gen.DaoMaster;
import com.example.administrator.xiaodemo2.gen.DaoSession;

public class MyApplication extends Application {
    public static MyApplication application;

    private DaoSession daoSession;


    public static MyApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        DbData();

    }

    private void DbData() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "mybean.db");

        SQLiteDatabase db = devOpenHelper.getWritableDatabase();

        DaoMaster daoMaster = new DaoMaster(db);

        daoSession=daoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}