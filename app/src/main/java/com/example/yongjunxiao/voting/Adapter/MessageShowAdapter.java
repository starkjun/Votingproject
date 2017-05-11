package com.example.yongjunxiao.voting.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yongjunxiao.voting.R;

import java.util.ArrayList;

/**
 * Created by yongjun.xiao on 17-4-25.
 */

public class MessageShowAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> arrayList;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;

    public MessageShowAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

        inflater = LayoutInflater.from(context);
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

        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.message_show_item,null);

            viewHolder.vote_title = (TextView) convertView.findViewById(R.id.vote_title);
            viewHolder.vote_content = (TextView) convertView.findViewById(R.id.vote_content);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    private static class ViewHolder{
        TextView vote_title;
        TextView vote_content;
    }

}
