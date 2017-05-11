package com.example.yongjunxiao.voting.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yongjunxiao.voting.Adapter.ContactsFragmentAdapter;
import com.example.yongjunxiao.voting.R;
import com.example.yongjunxiao.voting.Utils.MyDialog;

public class GroupList extends AppCompatActivity {

    private TextView group_number;
    private ListView listView;
    private ContactsFragmentAdapter adapter;
    private Toolbar toolbar;
    private TextView toolbar_title;
    private Button add_group;
    private MyDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);
        initView();

        adapter = new ContactsFragmentAdapter(this);
        listView.setAdapter(adapter);
        add_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
        setDialogListener();

    }

    private void initView(){

        dialog = new MyDialog(this);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        group_number = (TextView) findViewById(R.id.group_number);
        add_group = (Button) findViewById(R.id.add_group_btn);
        listView = (ListView) findViewById(R.id.listview);

        dialog.setTitle("请输入群组名");

        toolbar.setTitle("");
        toolbar_title.setText("群组列表");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setDialogListener(){
        dialog.setOnOkListener(new MyDialog.onOkListener() {
            @Override
            public void onClick() {
                dialog.dismiss();
            }
        });

        dialog.setOnCancleListener(new MyDialog.onCancelListener() {
            @Override
            public void onClick() {
                dialog.dismiss();
            }
        });
    }

}
