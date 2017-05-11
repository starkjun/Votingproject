package com.example.yongjunxiao.voting.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.yongjunxiao.voting.R;

import java.util.ArrayList;

/**
 * Created by yongjun.xiao on 17-4-25.
 */

public class BeginVotingAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> arrayList;

    public BeginVotingAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        arrayList = new ArrayList<>();
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView option;
        CheckBox checkBox;

        convertView = inflater.inflate(R.layout.vote_option_item,null);
        option = (TextView) convertView.findViewById(R.id.option_text);
        checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);

        return convertView;
    }
}
