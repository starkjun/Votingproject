package com.example.yongjunxiao.voting.model;

import android.content.Context;
import android.os.Handler;
import android.os.Message;


import com.example.yongjunxiao.voting.application.MyApplication;
import com.example.yongjunxiao.voting.model.impl.ILoginModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginModel implements ILoginModel {

    private final static OkHttpClient mhttpClient = MyApplication.getOkHttpClient();

    @Override
    public void login(Context context, String url, String account, String password, final Handler handler) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("account", account);
        builder.add("password", password);
        builder.add("rememberMe ", "0");
        final Request request = new Request.Builder().url(url).post(builder.build()).build();
        mhttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = new Message();
                message.what = 0x404;
                message.obj = e.getMessage();
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                try {
                    JSONObject object = new JSONObject(result);
                    Message message = new Message();
                    if (object.getBoolean("success")) {
                        message.what = 0x200;
                        message.obj = "登录成功";
                    } else {
                        message.what = 0x400;
                        message.obj = "登录失败";
                    }
                    handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Message message = new Message();
                    message.what = 0x404;
                    message.obj = e.getMessage();
                    handler.sendMessage(message);
                }

            }
        });
    }

    @Override
    public void loginSuccess() {

    }
}
