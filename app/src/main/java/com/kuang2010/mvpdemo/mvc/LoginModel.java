package com.kuang2010.mvpdemo.mvc;


import android.os.Handler;
import android.text.TextUtils;

import com.kuang2010.mvpdemo.mvp.model.UserBean;

/**
 * author: kuangzeyu2019
 * date: 2020/6/22
 * time: 20:21
 * desc:
 */
public class LoginModel implements ILoginModel {

    private ILoginView mILoginView;//持有view层

    public LoginModel(ILoginView loginView){
        mILoginView = loginView;
    }

    @Override
    public void login(final String userName, final String password) {
        mILoginView.showProgersss();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mILoginView.hideProgress();
                if (TextUtils.isEmpty(userName)){
                    mILoginView.showUserNameError();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    mILoginView.showPassWordError();
                    return;
                }

                UserBean userBean = new UserBean();
                userBean.name = "M V C";
                mILoginView.navigateSuccessPager(userBean);
            }
        }, 2000);
    }
}
