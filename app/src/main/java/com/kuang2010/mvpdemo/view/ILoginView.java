package com.kuang2010.mvpdemo.view;

import android.view.View;
import android.widget.Toast;

import com.kuang2010.mvpdemo.R;
import com.kuang2010.mvpdemo.model.UserBean;

/**
 * author: kuangzeyu2019
 * date: 2020/6/22
 * time: 18:02
 * desc:
 */
public interface ILoginView {

    void showProgress();

    void hideProgress();

    void showUserNameError();

    void showPasswordError();

    void navigateToSuccessPager(UserBean userBean);

}
