package com.example.yongjunxiao.voting.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yongjunxiao.voting.Adapter.BeginVotingAdapter;
import com.example.yongjunxiao.voting.R;
import com.example.yongjunxiao.voting.Utils.ListviewForScrollerview;

public class BeginVoting extends AppCompatActivity {


    private Toolbar toolbar;
    private Button submit_btn;
    private TextView toolbar_title;
    private TextView vote_title;
    private TextView vote_content;
    private ListviewForScrollerview listview;
    private TextView start_deadline_date;
    private BeginVotingAdapter  beginVotingAdapter;
    private Button modify_vote_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_voting);
        initView();

        beginVotingAdapter = new BeginVotingAdapter(this);
        listview.setAdapter(beginVotingAdapter);

        modify_vote_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BeginVoting.this,ModifyVote.class));
            }
        });

    }

    private void initView(){
        initToolbar();

        vote_title = (TextView) findViewById(R.id.vote_title);
        vote_content = (TextView) findViewById(R.id.vote_content);
        listview = (ListviewForScrollerview) findViewById(R.id.listview);
        start_deadline_date = (TextView) findViewById(R.id.start_deadline_date);
        submit_btn = (Button) findViewById(R.id.submit_btn);
        modify_vote_btn = (Button) findViewById(R.id.modify_vote_btn);
    }
    private void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        toolbar_title.setText("投票详情");
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
