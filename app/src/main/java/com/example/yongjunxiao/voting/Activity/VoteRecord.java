package com.example.yongjunxiao.voting.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yongjunxiao.voting.Adapter.RecordAdapter;
import com.example.yongjunxiao.voting.R;
import com.example.yongjunxiao.voting.Utils.ProtectedDialog;

import java.util.ArrayList;
import java.util.List;

public class VoteRecord extends AppCompatActivity {


    private Toolbar toolbar;
    private TextView toolbar_title;
    private ProtectedDialog dialog;
    private String dialogpsw;
    private RecordAdapter adapter;
    private ListView listView;
    private List<String> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_record);
        initView();
        arraylist = new ArrayList<>();
        arraylist.add("");
        arraylist.add("");
        arraylist.add("");
        arraylist.add("");

        adapter = new RecordAdapter(this, arraylist);
        listView.setAdapter(adapter);
        listView.setVisibility(View.INVISIBLE);


    }

    private void initView() {
        initToolbar();

        listView = (ListView) findViewById(R.id.listview);
        dialog = new ProtectedDialog(this);
        dialog.show();
        dialog.setOnOkListener(new ProtectedDialog.OnOkListener() {
            @Override
            public void onclick() {
                dialogpsw = dialog.getInputPSW();
                dialog.dismiss();
                listView.setVisibility(View.VISIBLE);
            }
        });
        dialog.setOnCancelListener(new ProtectedDialog.OnCancelListener() {
            @Override
            public void onclick() {
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
        toolbar_title.setText("投票记录");
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
