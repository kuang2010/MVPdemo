package com.kuang2010.mvpdemo.present;

import com.kuang2010.mvpdemo.model.UserBean;

/**
 * author: kuangzeyu2019
 * date: 2020/6/22
 * time: 18:13
 * desc:
 */
public interface OnLoginFinishListener {
    void onUserNameError();

    void onPasswordError();

    void onLoginSuccess(UserBean userBean);
}
