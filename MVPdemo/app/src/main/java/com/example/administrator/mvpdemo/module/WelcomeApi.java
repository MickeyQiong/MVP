package com.example.administrator.mvpdemo.module;

import com.example.administrator.mvpdemo.module.bean.WelcomeBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2017-3-6.
 */

public interface WelcomeApi {
    String HOST = "http://news-at.zhihu.com/api/4/";
    @GET()
    Observable<WelcomeBean> getWelcomeImg(@Path("res") String res);

}
