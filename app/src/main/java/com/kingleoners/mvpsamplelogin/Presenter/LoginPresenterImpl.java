package com.kingleoners.mvpsamplelogin.Presenter;

import com.kingleoners.mvpsamplelogin.Model.User;
import com.kingleoners.mvpsamplelogin.View.ILoginView;

public class LoginPresenterImpl implements ILoginPresenter{

    ILoginView loginView;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {

        User user = new User(email, password);
        boolean isLoginSuccess = user.isValid();

        if (isLoginSuccess)
            loginView.onLoginResult("Login Successfully");
        else
            loginView.onLoginResult("Login Error");

    }
}
