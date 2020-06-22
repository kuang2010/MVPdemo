package com.kuang2010.mvpdemo.mvc;

import com.kuang2010.mvpdemo.mvp.model.UserBean;

/**
 * author: kuangzeyu2019
 * date: 2020/6/22
 * time: 20:25
 * desc:
 */
public interface ILoginView {

    void showProgersss();

    void hideProgress();

    void showUserNameError();

    void showPassWordError();

    void navigateSuccessPager(UserBean userBean);
}
