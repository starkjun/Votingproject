package com.example.yongjunxiao.voting.model.impl;

import android.content.Context;

public interface INetConnect {
    /**
     * 判断网络是否连接
     *
     * @param context
     * @return
     */
    public abstract boolean isConnect(Context context);
}
