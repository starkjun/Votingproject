package com.example.yongjunxiao.voting.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yongjunxiao.voting.R;

import java.util.List;

/**
 * Created by yongjun.xiao on 17-4-24.
 */

public class RecordAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<String> arraylist;
    private ViewHolder viewHolder;

    public RecordAdapter(Context context, List<String> arraylist) {
        this.context = context;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.record_item, null);
            viewHolder = new ViewHolder();

            viewHolder.vote_title = (TextView) convertView.findViewById(R.id.vote_title);
            viewHolder.vote_content = (TextView) convertView.findViewById(R.id.vote_content);
            viewHolder.vote_date = (TextView) convertView.findViewById(R.id.start_deadline_date);
            viewHolder.vote_option = (TextView) convertView.findViewById(R.id.vote_option);

            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        return convertView;
    }

    private static class ViewHolder {
        private TextView vote_title;
        private TextView vote_content;
        private TextView vote_option;
        private TextView vote_date;
    }

}
