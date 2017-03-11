package com.example.administrator.mvpdemo.di.component;

import android.app.Activity;


import com.example.administrator.mvpdemo.MainActivity;
import com.example.administrator.mvpdemo.di.ActivityScope;
import com.example.administrator.mvpdemo.di.module.ActivityModule;
import com.example.administrator.mvpdemo.ui.WelcomeActivity;

import dagger.Component;

/**
 * Created by Administrator on 2016-10-15.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);

}
