package com.example.administrator.mvpdemo.di.module;

import com.example.administrator.mvpdemo.application.App;
import com.example.administrator.mvpdemo.di.ContextLife;
import com.example.administrator.mvpdemo.module.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017-3-6.
 */
@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }
    @Provides
    @Singleton
    @ContextLife("Application")
    App privodeApplicationContext(){
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }
}
