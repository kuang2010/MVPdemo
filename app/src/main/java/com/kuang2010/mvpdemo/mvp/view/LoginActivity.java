package com.kuang2010.mvpdemo.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kuang2010.mvpdemo.R;
import com.kuang2010.mvpdemo.mvp.model.UserBean;
import com.kuang2010.mvpdemo.mvp.present.ILoginPresenter;
import com.kuang2010.mvpdemo.mvp.present.LoginPresenter;

/**
 * 登录的视图，相当于MVP模式中的View层，定义封装了对UI的操作方法（初始化和刷新UI），并通过持有Present层或其接口的引用，触发登录加载数据。
 * View层不能出现对Model层的引用
 * */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginView {

    private EditText mUsername;
    private EditText mPassword;
    private Button mButton;
    private ProgressBar mProgress;
    private ILoginPresenter mLoginPresenter;//V中持有P的接口的引用

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mButton = findViewById(R.id.button);
        mProgress = findViewById(R.id.progress);
        mButton.setOnClickListener(this);
        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        //登录，触发登录，加载数据
        mLoginPresenter.login(mUsername.getText().toString(),mPassword.getText().toString());
    }

    @Override
    public void showProgress(){
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress(){
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showUserNameError(){
        mUsername.setError(getResources().getString(R.string.username_error));
    }

    @Override
    public void showPasswordError(){
        mPassword.setError(getResources().getString(R.string.password_error));
    }

    @Override
    public void navigateToSuccessPager(UserBean userBean){
        Toast.makeText(this,userBean.name+"登录成功，跳转到成功页面",Toast.LENGTH_SHORT).show();
    }
}
