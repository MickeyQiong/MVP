package com.example.administrator.mvpdemo.di.module;

import android.app.Activity;


import com.example.administrator.mvpdemo.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016-10-15.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity(){
        return mActivity;
    }
}
