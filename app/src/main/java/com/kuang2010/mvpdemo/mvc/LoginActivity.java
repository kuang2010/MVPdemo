package com.kuang2010.mvpdemo.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kuang2010.mvpdemo.R;
import com.kuang2010.mvpdemo.mvp.model.UserBean;
/*********MVC主要是把Model层给抽出去**********/
/** View + Control */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginView {

    private EditText mUsername;
    private EditText mPassword;
    private Button mButton;
    private ProgressBar mProgress;
    private ILoginModel mLoginModel;////持有Model层

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mButton = findViewById(R.id.button);
        mProgress = findViewById(R.id.progress);
        mButton.setOnClickListener(this);

        mLoginModel = new LoginModel(this);
    }

    @Override
    public void onClick(View v) {

        mLoginModel.login(mUsername.getText().toString(),mPassword.getText().toString());
    }

    @Override
    public void showProgersss() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showUserNameError() {
        mUsername.setError(getResources().getString(R.string.username_error));
    }

    @Override
    public void showPassWordError() {
        mPassword.setError(getResources().getString(R.string.password_error));
    }

    @Override
    public void navigateSuccessPager(UserBean userBean) {
        Toast.makeText(this,userBean.name+"登录成功，即将进入下个页面",Toast.LENGTH_SHORT).show();
    }
}
