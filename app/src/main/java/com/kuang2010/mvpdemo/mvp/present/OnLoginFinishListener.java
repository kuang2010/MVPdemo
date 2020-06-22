package com.kuang2010.mvpdemo.mvp.present;

import com.kuang2010.mvpdemo.mvp.model.UserBean;

/**
 * author: kuangzeyu2019
 * date: 2020/6/22
 * time: 18:13
 * desc: OnLoginFinishedListener，其在Presenter层实现，给Model层回调，更改View层的状态，
 * 确保 Model层不直接操作View层。
 */
public interface OnLoginFinishListener {
    void onUserNameError();

    void onPasswordError();

    void onLoginSuccess(UserBean userBean);
}
