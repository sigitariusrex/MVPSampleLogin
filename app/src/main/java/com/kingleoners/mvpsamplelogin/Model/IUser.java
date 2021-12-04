package com.kingleoners.mvpsamplelogin.Model;

public interface IUser {

    String getEmail();
    String getPassword();
    boolean isValid();

}
