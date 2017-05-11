package com.example.yongjunxiao.voting.entity;

import java.io.Serializable;

/**
 * Created by starkjun on 2017/5/10.
 */

public class User implements Serializable{

    private String user_id;
    private String user_paswd;
    private String user_gender;
    private String user_area;
    private static volatile User instance;

    private User(){}

    public static User getInstance(){

        if (instance == null){
            synchronized (User.class){
                if(instance == null){
                    instance = new User();
                }
            }
        }

        return  instance;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_paswd() {
        return user_paswd;
    }

    public void setUser_paswd(String user_paswd) {
        this.user_paswd = user_paswd;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_area() {
        return user_area;
    }

    public void setUser_area(String user_area) {
        this.user_area = user_area;
    }
}
