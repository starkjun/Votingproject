package com.example.yongjunxiao.voting.iview;

public interface ILoginView {

    public abstract void showProgressBar();

    public abstract void hideProgressBar();

    public abstract void startActivity();

    public abstract String getAccount();

    public abstract String getPassword();

    public void showResult(String msg);

}
