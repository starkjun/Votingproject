package com.example.yongjunxiao.voting.application;

import android.app.Application;
import android.content.Context;


import com.example.yongjunxiao.voting.Utils.PersistentCookieStore;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class MyApplication extends Application {

    private static Context context;
    private static volatile OkHttpClient mOkHttpClient;
    private static PersistentCookieStore cookieStore;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        cookieStore = new PersistentCookieStore(context);
    }

    public static Context getContext() {
        return context;
    }

    public static OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (MyApplication.class) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient.Builder().cookieJar(new CookieJar() {
                        @Override
                        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                            if (list != null && list.size() > 0) {
                                for (Cookie item : list) {
                                    cookieStore.add(httpUrl, item);
                                }
                            }
                        }

                        @Override
                        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                            List<Cookie> cookies = cookieStore.get(httpUrl);
                            return cookies;
                        }
                    }).build();
                    mOkHttpClient.cookieJar();
                }
            }
        }
        return mOkHttpClient;
    }

}
