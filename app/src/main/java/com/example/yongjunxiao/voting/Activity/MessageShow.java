package com.example.yongjunxiao.voting.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yongjunxiao.voting.Adapter.MessageShowAdapter;
import com.example.yongjunxiao.voting.R;

import java.util.ArrayList;

public class MessageShow extends AppCompatActivity implements View.OnClickListener{

    private MessageShowAdapter showAdapter;
    private ListView listView;
    private Toolbar toolbar;
    private TextView toolbar_title;
    private Button create_vote;
    private Button group_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_show);
        initView();

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
        arrayList.add("");

        showAdapter = new MessageShowAdapter(this, arrayList);
        listView.setAdapter(showAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MessageShow.this,BeginVoting.class));
            }
        });




    }

    private void initView() {
        initToolbar();
        listView = (ListView) findViewById(R.id.message_show_list);
        create_vote = (Button) findViewById(R.id.create_vote);
        group_info = (Button) findViewById(R.id.group_info);

        create_vote.setOnClickListener(this);
        group_info.setOnClickListener(this);

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);

        toolbar.setTitle("群组");
        toolbar_title.setText("");
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
        switch (v.getId()){

            case R.id.create_vote:
                startActivity(new Intent(MessageShow.this,CreateVote.class));
                break;
            case R.id.group_info:
                startActivity(new Intent(MessageShow.this,GroupInfo.class));
                break;

        }
    }
}
