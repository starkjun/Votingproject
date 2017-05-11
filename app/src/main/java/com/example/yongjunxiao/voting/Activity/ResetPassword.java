package com.example.yongjunxiao.voting.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yongjunxiao.voting.R;

public class ResetPassword extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText old_psw;
    private EditText new_psw;
    private Button confirm_btn;
    private TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initView();
    }

    private void initView() {
        initToolbar();


        old_psw = (EditText) findViewById(R.id.old_psw);
        new_psw = (EditText) findViewById(R.id.new_psw);
        confirm_btn = (Button) findViewById(R.id.confirm_btn);

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        toolbar_title.setText("重置密码");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
