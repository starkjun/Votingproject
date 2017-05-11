package com.example.yongjunxiao.voting.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.yongjunxiao.voting.R;

import java.util.ArrayList;

/**
 * Created by yongjun.xiao on 17-4-18.
 */

public class VoteOptionAdapter extends BaseAdapter implements View.OnClickListener{

    private Context context;
    public ArrayList<String> arrayList;
    public LayoutInflater layoutInflater;
    private int pos;

    public VoteOptionAdapter(Context context) {
        this.context = context;
        arrayList = new ArrayList<>();
        arrayList.add("");
        arrayList.add("");
        layoutInflater = LayoutInflater.from(context);
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

        final EditText option_item;
        Button bt_delete;
        Button bt_add;
        pos = position;
        convertView = layoutInflater.inflate(R.layout.vote_item,null);
        option_item = (EditText) convertView.findViewById(R.id.vote_option);
        bt_add = (Button) convertView.findViewById(R.id.add_btn);
        bt_delete = (Button) convertView.findViewById(R.id.delete_btn);
        option_item.setHint("选项"+String.valueOf(position));

        if(position >= 1&&position<arrayList.size()-1){
            bt_add.setVisibility(View.INVISIBLE);
            bt_delete.setVisibility(View.VISIBLE);
        }
        if(position == arrayList.size() -1){
            bt_add.setVisibility(View.VISIBLE);
        }

        option_item.setText(arrayList.get(position).toString());
        option_item.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (arrayList.size() > 0) {
                    arrayList.set(pos, option_item.getText().toString());
                }
            }
        });

        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn:
                arrayList.add("");
                this.notifyDataSetChanged();
                break;
            case R.id.delete_btn:
                arrayList.remove(pos);
                this.notifyDataSetChanged();
        }
    }
}
