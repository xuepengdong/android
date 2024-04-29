package com.bailitop.chapter06;

import android.app.Application;

import java.util.HashMap;

public class MainApplication  extends Application  {
    private static MainApplication mApp;

    public HashMap<String, String> infoMap = new HashMap<>();

    public static MainApplication getInstance(){
        return mApp;
    }

    @Override
    public void  onCreate(){
        super.onCreate();
        mApp = this;
    }
    
}
