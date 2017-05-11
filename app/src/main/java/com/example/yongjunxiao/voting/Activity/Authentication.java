package com.example.yongjunxiao.voting.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yongjunxiao.voting.R;

public class Authentication extends AppCompatActivity {

    /**
     * @param authentic  if authentic = 0,it means the user is not authenticated,
     * if authentic = 1,it means the user is authenticated.
     */
    private int authentic;
    private EditText real_name;
    private EditText id_number;
    private Button confirm_btn;
    private Toolbar toolbar;
    private TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        initView();
    }

    private void initView() {
        real_name = (EditText) findViewById(R.id.real_name);
        id_number = (EditText) findViewById(R.id.id_number);
        confirm_btn = (Button) findViewById(R.id.confirm_btn);

        initToolbar();


    }

    private void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText("实名认证");
        toolbar.setTitle("");
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
