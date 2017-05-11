package com.example.yongjunxiao.voting.iview;

public interface IRegisterView {

    public abstract void showProgressBar();

    public abstract void hideProgressBar();

    public abstract void startActivity();

    public abstract String getAccount();

    public abstract String getPassword();

    public abstract String getPassword2();

    public void showResult(String msg);

}
