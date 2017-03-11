package com.example.administrator.mvpdemo.presenter.contract;

import android.view.View;

import com.example.administrator.mvpdemo.base.BasePresenter;
import com.example.administrator.mvpdemo.base.BaseView;
import com.example.administrator.mvpdemo.module.bean.WelcomeBean;

/**
 * Created by Administrator on 2017-3-7.
 */

public interface WelcomeContract {
    interface View extends BaseView {
        void showContent(WelcomeBean welcomeBean);
        void jumpToMain();
    }
    interface Presenter extends BasePresenter<View>{
        void getWelcomeData();
    }
}
