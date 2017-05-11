package com.example.yongjunxiao.voting.model.impl;

import android.content.Context;
import android.os.Handler;

public interface ILoginModel {
    /**
     * 登录行为
     *
     * @param context  上下文
     * @param url      登录链接
     * @param account  账号
     * @param password 密码
     * @param handler  更新界面的Handler
     */
    public abstract void login(Context context, String url, String account,
                               String password, Handler handler);

    /**
     * 登录成功
     */
    public abstract void loginSuccess();

}
