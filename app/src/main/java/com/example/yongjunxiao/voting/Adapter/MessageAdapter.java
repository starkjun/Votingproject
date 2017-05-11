package com.example.yongjunxiao.voting.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yongjunxiao.voting.R;

import java.util.ArrayList;

/**
 * Created by yongjun.xiao on 17-4-25.
 */

public class MessageAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> arrayList;
    private ViewHolder viewHolder;

    public MessageAdapter(Context context, ArrayList<String> arrayList) {
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

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.message_item,null);

            viewHolder.group_icon = (ImageView) convertView.findViewById(R.id.group_icon);
            viewHolder.group_name = (TextView) convertView.findViewById(R.id.group_name);
            viewHolder.message_title = (TextView) convertView.findViewById(R.id.message_title);
            viewHolder.release_time = (TextView) convertView.findViewById(R.id.release_time);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }



        return convertView;
    }

    private static class ViewHolder {
        ImageView group_icon;
        TextView group_name;
        TextView message_title;
        TextView release_time;
    }


}
