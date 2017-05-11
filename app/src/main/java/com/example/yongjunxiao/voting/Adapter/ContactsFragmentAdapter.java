package com.example.yongjunxiao.voting.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.yongjunxiao.voting.R;

/**
 * Created by yongjun.xiao on 17-4-26.
 */

public class ContactsFragmentAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    public ContactsFragmentAdapter(Context context) {
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.contacts_item,null);

        return convertView;
    }
}
