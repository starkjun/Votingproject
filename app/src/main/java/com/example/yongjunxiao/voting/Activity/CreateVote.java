package com.example.yongjunxiao.voting.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yongjunxiao.voting.Adapter.VoteOptionAdapter;
import com.example.yongjunxiao.voting.R;
import com.example.yongjunxiao.voting.Utils.ListviewForScrollerview;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateVote extends AppCompatActivity implements OnDateSetListener {

    private Toolbar toolbar;
    private TextView toolbar_title;
    private ListviewForScrollerview listview;
    private VoteOptionAdapter voteOptionAdapter;
    private ImageView select_time;
    private TextView current_date;
    private EditText vote_title;
    private EditText vote_content;
    private com.jzxiang.pickerview.TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_vote);

        initView();

        voteOptionAdapter = new VoteOptionAdapter(this);
        listview.setAdapter(voteOptionAdapter);

        select_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show(getSupportFragmentManager(), "xxx");
            }
        });
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        listview = (ListviewForScrollerview) findViewById(R.id.vote_list);
        select_time = (ImageView) findViewById(R.id.selece_time_image);
        current_date = (TextView) findViewById(R.id.date_text);
        vote_title = (EditText) findViewById(R.id.vote_title);
        vote_content = (EditText) findViewById(R.id.vote_content);

        timePickerDialog = new com.jzxiang.pickerview.TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("选择时间")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis())
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(12)
                .build();

        toolbar.setTitle("");
        toolbar_title.setText("建立投票");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    public String getDateToString(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    @Override
    public void onDateSet(com.jzxiang.pickerview.TimePickerDialog timePickerView, long millseconds) {
        String date = getDateToString(millseconds);
        current_date.setText(date);
    }
}
