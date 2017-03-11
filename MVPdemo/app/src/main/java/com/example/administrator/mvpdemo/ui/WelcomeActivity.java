package com.example.administrator.mvpdemo.ui;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mvpdemo.MainActivity;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.base.BaseActivity;
import com.example.administrator.mvpdemo.module.bean.WelcomeBean;
import com.example.administrator.mvpdemo.presenter.WelcomePresenter;
import com.example.administrator.mvpdemo.presenter.contract.WelcomeContract;
import com.example.administrator.mvpdemo.util.ImageLoader;

import butterknife.BindView;

/**
 * Created by Administrator on 2017-3-7.
 */

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {

    @BindView(R.id.tv_welcome_author)
    TextView textView;
    @BindView(R.id.iv_welcome_bg)
    ImageView imageView;

    @Override
    protected void initEventAndData() {
        mPresenter.getWelcomeData();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {
        ImageLoader.load(WelcomeActivity.this,welcomeBean.getImg(),imageView);
        imageView.animate().scaleY(1.2f).scaleY(1.2f).setStartDelay(2000).setDuration(2000).start();
        textView.setText(welcomeBean.getText());
    }

    @Override
    public void jumpToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Glide.clear(imageView);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void isNightMode(boolean isNight) {

    }
}
