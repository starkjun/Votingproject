package com.example.yongjunxiao.voting.Activity;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_nickname;
    private EditText et_account;
    private EditText et_passwd;
    private EditText et_repasswd;
    private Button register_btn;
    private Toolbar toolbar;
    private TextView toolbar_title;
    private ProgressDialog dialog;


    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x200:
                    dialog.dismiss();
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    RegisterActivity.this.finish();
                    break;
                case 0x400:
                    dialog.dismiss();
                    Toast.makeText(RegisterActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }

    private void register(){

        String nickname = et_nickname.getText().toString();
        String account = et_account.getText().toString();
        String passwd = et_passwd.getText().toString();
        String repasswd = et_repasswd.getText().toString();

        if (!passwd.equals(repasswd)) {
            Toast.makeText(RegisterActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
        } else if (passwd.length() < 2 || repasswd.length() < 2) {
            Toast.makeText(RegisterActivity.this, "两密码长度至少为2位", Toast.LENGTH_SHORT).show();
        }else {
            dialog.show();
            FormBody formBody = new FormBody.Builder().add("name", nickname).add("password", passwd).add("account" , account).build();
            Request request = new Request.Builder().url(Resource.Register).post(formBody).build();

            MyApplication.getOkHttpClient().newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Message msg = mHandler.obtainMessage(0x400);
                    msg.obj = e.getMessage();
                    mHandler.sendMessage(msg);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String result = response.body().string();
                    Log.d("RegisterActivity:", "onResponse:" + result);
                    try {
                        JSONObject object = new JSONObject(result);
                        if (object.getBoolean("success")) {
                            mHandler.sendEmptyMessage(0x200);
                        } else {
                            Message msg = mHandler.obtainMessage(0x400);
                            msg.obj = "注册失败";
                            mHandler.sendMessage(msg);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Message msg = mHandler.obtainMessage(0x400);
                        msg.obj = e.getMessage();
                        mHandler.sendMessage(msg);
                    }
                }
            });

        }

    }

    private void initView(){
        if (dialog == null) {
            dialog = new ProgressDialog(this);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setMessage("注册中...");
        }
        initToolbar();
        et_nickname = (EditText) findViewById(R.id.nick_name);
        et_account = (EditText) findViewById(R.id.account);
        et_passwd = (EditText) findViewById(R.id.password);
        et_repasswd = (EditText) findViewById(R.id.confirm_password);
        register_btn = (Button) findViewById(R.id.register_btn);
    }
    private void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar_title.setText("注册");

    }

}
