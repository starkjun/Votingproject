package com.example.yongjunxiao.voting.entity;

/**
 * Created by starkjun on 2017/5/10.
 */

public class Resource {
    /**
     * 接口域名，使用时拼接相应接口
     */
    public static final String Domain = "http://cgztkc.com:8082/votingsystem/";
    /**
     * 登录接口
     *
    */
    public static final String Login = Domain +"/auth/login";
    public static final String Register = Domain +"/auth/login";
    public static final String Logout = Domain +"/logout";
    public static final String ResetPaswd = Domain +"/user/password";
    public static final String ResetInfo = Domain +"/user/";
    public static final String GetFriendList = Domain +"/user";
    public static final String GetUserInfo = Domain + "/user/";


}
