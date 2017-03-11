package com.example.administrator.mvpdemo.di.component;


import com.example.administrator.mvpdemo.application.App;
import com.example.administrator.mvpdemo.di.ContextLife;
import com.example.administrator.mvpdemo.di.module.AppModule;
import com.example.administrator.mvpdemo.module.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016-10-15.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    App getContext();  // 提供App的Context

    RetrofitHelper retrofitHelper();  //提供http的帮助类

}
