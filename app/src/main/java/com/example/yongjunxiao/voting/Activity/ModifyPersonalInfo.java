package com.example.yongjunxiao.voting.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yongjunxiao.voting.R;
import com.example.yongjunxiao.voting.Utils.MyDialog;

public class ModifyPersonalInfo extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView toolbar_title;
    private RelativeLayout edit_nick_name;
    private RelativeLayout edit_gender;
    private RelativeLayout edit_area;
    private MyDialog dialog;
    private int content_number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_personal_info);
        initView();
        initToolbar();
    }

    private void initView() {
        dialog = new MyDialog(this);
        edit_nick_name = (RelativeLayout) findViewById(R.id.nick_name);
        edit_gender = (RelativeLayout) findViewById(R.id.gender);
        edit_area = (RelativeLayout) findViewById(R.id.area);

        edit_nick_name.setOnClickListener(this);
        edit_gender.setOnClickListener(this);
        edit_area.setOnClickListener(this);

        dialog.setOnOkListener(new MyDialog.onOkListener() {
            @Override
            public void onClick() {
                switch (content_number) {
                    /**
                     * get the modified content here,and modified the user message here.
                     */

                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
                dialog.clearEditText();
                dialog.dismiss();
            }
        });
        dialog.setOnCancleListener(new MyDialog.onCancelListener() {
            @Override
            public void onClick() {
                dialog.clearEditText();
                dialog.dismiss();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        dialog.dismiss();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText("帐号信息");
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nick_name:
                content_number = 1;
                dialog.show();
                break;
            case R.id.gender:
                content_number = 2;
                dialog.show();
                break;
            case R.id.area:
                content_number = 3;
                dialog.show();
                break;
        }
    }
}
