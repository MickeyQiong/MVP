package com.example.administrator.mvpdemo.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2017-3-7.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T view;
    protected CompositeSubscription compositeSubscription;

    protected void unSubscribe(){
        if (compositeSubscription!=null){
            compositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription){
        if (compositeSubscription==null){
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        unSubscribe();
    }
}
