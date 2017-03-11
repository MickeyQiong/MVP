package com.example.administrator.mvpdemo.presenter;

import com.example.administrator.mvpdemo.base.RxPresenter;
import com.example.administrator.mvpdemo.module.bean.WelcomeBean;
import com.example.administrator.mvpdemo.module.http.RetrofitHelper;
import com.example.administrator.mvpdemo.presenter.contract.WelcomeContract;
import com.example.administrator.mvpdemo.util.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017-3-7.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {
    private static final String RES = "1080*1776";

    private static final int COUNT_DOWN_TIME = 2200;

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public WelcomePresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }


    @Override
    public void getWelcomeData() {
        Subscription subscription = mRetrofitHelper.welcomeInfo(RES)
                .compose(RxUtil.<WelcomeBean>rxSchedulerHelper())
                .subscribe(new Action1<WelcomeBean>() {
                    @Override
                    public void call(WelcomeBean welcomeBean) {
                        view.showContent(welcomeBean);
                        startCount();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        view.showError(throwable.toString());
                        view.jumpToMain();
                    }
                });
        addSubscribe(subscription);
    }

    private void startCount() {
        Subscription rxSubscription = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        view.jumpToMain();
                    }
                });
        addSubscribe(rxSubscription);
    }


}
