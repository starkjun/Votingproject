package com.example.yongjunxiao.voting.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yongjunxiao.voting.Adapter.ContactsFragmentAdapter;
import com.example.yongjunxiao.voting.R;
import com.example.yongjunxiao.voting.Utils.MyDialog;

public class GroupInfo extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout group_dismiss;
    private Button invitation;
    private ListView listView;
    private ContactsFragmentAdapter adapter;
    private Toolbar toolbar;
    private TextView toolbar_title;
    private MyDialog myDialog;
    private MyDialog dissmissDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info);
        initView();


        adapter = new ContactsFragmentAdapter(this);
        listView.setAdapter(adapter);
        setMyDialogListener();


    }


    private void initView() {

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        group_dismiss = (RelativeLayout) findViewById(R.id.group_dismiss);
        invitation = (Button) findViewById(R.id.invitation);
        listView = (ListView) findViewById(R.id.listview);
        myDialog = new MyDialog(this);
        dissmissDialog = new MyDialog(this);

        group_dismiss.setOnClickListener(this);
        invitation.setOnClickListener(this);

        myDialog.setTitle("请输入帐号");
        dissmissDialog.setTitle("确定要退出该群组？？");
        dissmissDialog.setCanceledOnTouchOutside(true);
        dissmissDialog.setEditTexthint();

        toolbar.setTitle("");
        toolbar_title.setText("群组信息");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setMyDialogListener() {
        myDialog.setOnOkListener(new MyDialog.onOkListener() {
            @Override
            public void onClick() {
                myDialog.clearEditText();
                myDialog.dismiss();
            }
        });

        myDialog.setOnCancleListener(new MyDialog.onCancelListener() {
            @Override
            public void onClick() {
                myDialog.clearEditText();
                myDialog.dismiss();
            }
        });

        dissmissDialog.setOnOkListener(new MyDialog.onOkListener() {
            @Override
            public void onClick() {
                dissmissDialog.dismiss();
            }
        });

        dissmissDialog.setOnCancleListener(new MyDialog.onCancelListener() {
            @Override
            public void onClick() {
                dissmissDialog.dismiss();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.group_dismiss:
                dissmissDialog.show();
                break;
            case R.id.invitation:
                myDialog.show();
                break;
        }
    }
}
