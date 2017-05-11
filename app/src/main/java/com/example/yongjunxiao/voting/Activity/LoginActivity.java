package com.example.yongjunxiao.voting.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yongjunxiao.voting.R;
import com.example.yongjunxiao.voting.application.MyApplication;
import com.example.yongjunxiao.voting.entity.Resource;
import com.example.yongjunxiao.voting.iview.ILoginView;
import com.example.yongjunxiao.voting.presenter.LoginPresenter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginView {

    private EditText et_account;
    private EditText et_password;
    private Button register;
    private Button reset_password;
    private Button login_btn;
    private LoginPresenter presenter;
    private ProgressDialog dialog;
    private Toolbar toolbar;
    private TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        presenter = new LoginPresenter(this);

    }
    private void initView(){

        initToolbar();
        et_account = (EditText) findViewById(R.id.account);
        et_password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register_btn);
        reset_password = (Button) findViewById(R.id.forget_password_btn);
        login_btn = (Button) findViewById(R.id.login_btn);

        register.setOnClickListener(this);
        reset_password.setOnClickListener(this);
        login_btn.setOnClickListener(this);

    }
    private void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        toolbar_title.setText("登录");
        setSupportActionBar(toolbar);
    }

    @Override
    public void showProgressBar() {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.setMessage("登录中...");
        }
        dialog.show();
    }

    @Override
    public void hideProgressBar() {
        dialog.dismiss();
    }

    @Override
    public void startActivity() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        LoginActivity.this.finish();
    }

    @Override
    public String getAccount() {
        return et_account.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString();
    }

    @Override
    public void showResult(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.register_btn:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.forget_password_btn:
                break;
            case R.id.login_btn:
                presenter.login(this, Resource.Login);
                break;
            default:
                break;

        }
    }
}
