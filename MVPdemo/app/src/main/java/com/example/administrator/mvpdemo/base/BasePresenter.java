package com.example.administrator.mvpdemo.base;

/**
 * Created by Administrator on 2017-3-6.
 */

public interface BasePresenter<T extends BaseView>{
    void attachView(T view);
    void detachView();
}
