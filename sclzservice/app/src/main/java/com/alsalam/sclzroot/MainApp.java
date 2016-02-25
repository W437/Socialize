package com.alsalam.sclzroot;

import android.app.Application;
import android.support.multidex.MultiDex;

/**
 * Created by samih on 25/02/2016.
 */
public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}
