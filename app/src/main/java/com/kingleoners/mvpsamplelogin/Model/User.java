package com.kingleoners.mvpsamplelogin.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements IUser{

    private String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isValid() {
        return !TextUtils.isEmpty(getEmail()) //email empty
                && !TextUtils.isEmpty(getPassword()) //password empty
                && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() //check email pattern
                && getPassword().length() > 8 //password length > 8
                ;
    }
}
