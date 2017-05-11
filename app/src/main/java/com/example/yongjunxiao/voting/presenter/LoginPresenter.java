package com.example.yongjunxiao.voting.presenter;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;


import com.example.yongjunxiao.voting.iview.ILoginView;
import com.example.yongjunxiao.voting.model.LoginModel;
import com.example.yongjunxiao.voting.model.NetConnect;
import com.example.yongjunxiao.voting.model.impl.ILoginModel;
import com.example.yongjunxiao.voting.model.impl.INetConnect;

import java.lang.ref.WeakReference;

public class LoginPresenter {

    private INetConnect connect;
    private static ILoginView loginView;
    private static ILoginModel loginModel;
    private MyHandler mHandler;

    static class MyHandler extends Handler {

        WeakReference<ILoginView> mWeakReference;

        public MyHandler(ILoginView loginView) {
            mWeakReference = new WeakReference<ILoginView>(loginView);
        }

        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0x200:
                    loginView.hideProgressBar();
                    loginModel.loginSuccess();
                    loginView.showResult((String) msg.obj);
                    loginView.startActivity();
                    break;

                case 0x400:
                    loginView.hideProgressBar();
                    loginView.showResult((String) msg.obj);
                    break;
                case 0x404:
                    loginView.hideProgressBar();
                    loginView.showResult((String) msg.obj);
                    break;
            }
        }
    }

    public LoginPresenter(ILoginView loginView) {
        LoginPresenter.loginView = loginView;
        loginModel = (ILoginModel) new LoginModel();
        connect = (INetConnect) new NetConnect();
        mHandler = new MyHandler(loginView);
    }

    public void login(Context context, String url) {
        String acc = loginView.getAccount();
        String psw = loginView.getPassword();
        if (acc.isEmpty() || psw.isEmpty()) {
            Toast.makeText(context, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (connect.isConnect(context)) {
            loginView.showProgressBar();
            loginModel.login(context, url, acc, psw, mHandler);
        } else {
            Toast.makeText(context, "无法连接网络", Toast.LENGTH_LONG).show();
        }
    }
}
