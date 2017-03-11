package com.example.administrator.mvpdemo.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.example.administrator.mvpdemo.di.component.AppComponent;
import com.example.administrator.mvpdemo.di.component.DaggerAppComponent;
import com.example.administrator.mvpdemo.di.module.AppModule;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017-3-6.
 */

public class App extends Application {

    private static App instance;

    private Set<Activity> activities;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    public static synchronized App getInstance(){
        return instance;
    }

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        getScreenSize();
    }

    public void addActivity(Activity activity){
        if (activities == null){
            activities = new HashSet<>();
        }
        activities.add(activity);
    }

    public void removeActivity(Activity activity){
        if (activities!=null){
            activities.remove(activity);
        }
    }

    public void getScreenSize() {
        WindowManager windowManager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if(SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }

    public static AppComponent getAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }
}
