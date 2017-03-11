package com.example.administrator.mvpdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.administrator.mvpdemo.application.App;
import com.example.administrator.mvpdemo.di.component.ActivityComponent;
import com.example.administrator.mvpdemo.di.component.DaggerActivityComponent;
import com.example.administrator.mvpdemo.di.module.ActivityModule;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Administrator on 2017-3-6.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {

    protected T mPresenter;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        mContext = this;
        initInject();
        if (mPresenter!=null){
           mPresenter.attachView(this);
        }
        App.getInstance().addActivity(this);
        initEventAndData();
    }

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    protected abstract void initEventAndData();

    protected abstract void initInject();

    protected abstract int getLayout();
}
