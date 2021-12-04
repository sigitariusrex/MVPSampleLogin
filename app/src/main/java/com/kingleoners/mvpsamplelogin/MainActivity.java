package com.kingleoners.mvpsamplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kingleoners.mvpsamplelogin.Presenter.ILoginPresenter;
import com.kingleoners.mvpsamplelogin.Presenter.LoginPresenterImpl;
import com.kingleoners.mvpsamplelogin.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText edt_email, edt_password;
    Button btn_login;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initPresenter();
        onClick();
    }

    private void onClick() {

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(edt_email.getText().toString(),
                        edt_password.getText().toString());
            }
        });
    }

    private void initPresenter() {

        loginPresenter = new LoginPresenterImpl(this);
    }

    private void initView() {

        edt_email = (EditText)findViewById(R.id.edtEmail);
        edt_password = (EditText)findViewById(R.id.edtPassword);
        btn_login = (Button)findViewById(R.id.btnLogin);
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}