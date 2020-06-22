package com.kuang2010.mvpdemo.model;

import com.kuang2010.mvpdemo.present.OnLoginFinishListener;

/**
 * author: kuangzeyu2019
 * date: 2020/6/22
 * time: 18:21
 * desc:模拟登陆的操作的接口，实现类为LoginModel
 */
public interface ILoginModel {

    void loadDataToLogin( String userName,  String passsword,  OnLoginFinishListener loginFinishListener);
}
