package com.kuang2010.mvpdemo.mvp.present;

import com.kuang2010.mvpdemo.mvp.model.ILoginModel;
import com.kuang2010.mvpdemo.mvp.model.LoginModel;
import com.kuang2010.mvpdemo.mvp.model.UserBean;
import com.kuang2010.mvpdemo.mvp.view.ILoginView;

/**
 * author: kuangzeyu2019
 * date: 2020/6/22
 * time: 18:17
 * desc: 登录控制器，相当于MVP模式中的presenter,控制Model层和View层的交互和操作，通过持有M和V的引用或它们接口的引用，
 * 定义封装了 调用 m和v中方法 的方法及调用逻辑，
 *
 * P: M与V之间的交互和控制
 */
public class LoginPresenter implements ILoginPresenter, OnLoginFinishListener {

    private  ILoginModel mLoginModel;//P中持有M的接口的引用
    private  ILoginView mILoginView;//P中持有V的接口的引用
    public LoginPresenter(ILoginView loginView) {
        mLoginModel = new LoginModel();
        mILoginView =loginView;
    }

    @Override
    public void login(String name,String password) {
        mILoginView.showProgress();
        mLoginModel.loadDataToLogin(name,password,this);
    }

    @Override
    public void onUserNameError() {
        mILoginView.showUserNameError();
        mILoginView.hideProgress();
    }

    @Override
    public void onPasswordError() {
        mILoginView.showPasswordError();
        mILoginView.hideProgress();
    }

    @Override
    public void onLoginSuccess(UserBean userBean) {
        mILoginView.hideProgress();
        mILoginView.navigateToSuccessPager(userBean);
    }
}
