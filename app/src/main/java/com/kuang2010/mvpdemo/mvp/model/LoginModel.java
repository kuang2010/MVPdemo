package com.kuang2010.mvpdemo.mvp.model;

import android.os.Handler;
import android.text.TextUtils;

import com.kuang2010.mvpdemo.mvp.present.OnLoginFinishListener;

/**
 * author: kuangzeyu2019
 * date: 2020/6/22
 * time: 18:06
 * desc: 具体登陆业务逻辑处理的实现。 相当于MVP模式中的Model层，定义封装了对数据的操作方法(获取数据),并且通过持有Present层或其接口的引用，通知刷新UI。
 * Model层不能出现对View层的引用
 *
 * M:提供数据模型+实现具体业务逻辑
 */
public class LoginModel implements ILoginModel{

    /**
     * @param userName
     * @param passsword
     * @param loginFinishListener M中持有P的接口的引用
     */
    @Override
    public void loadDataToLogin(final String userName, final String passsword, final OnLoginFinishListener loginFinishListener){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(userName)){
                    loginFinishListener.onUserNameError();
                    return;
                }

                if (TextUtils.isEmpty(passsword)){
                    loginFinishListener.onPasswordError();
                    return;
                }

                UserBean userBean = new UserBean();
                userBean.name = "M V P";
                loginFinishListener.onLoginSuccess(userBean);


            }
        },2000 );
    }
}
