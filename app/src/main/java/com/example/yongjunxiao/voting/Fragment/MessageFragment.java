package com.example.yongjunxiao.voting.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yongjunxiao.voting.Activity.MessageShow;
import com.example.yongjunxiao.voting.Adapter.MessageAdapter;
import com.example.yongjunxiao.voting.R;

import java.util.ArrayList;

/**
 * Created by yongjun.xiao on 17-4-25.
 */

public class MessageFragment extends Fragment {

    private View view;
    private MessageAdapter messageAdapter;
    private ArrayList<String> arrayList;
    private Context context;
    private ListView message_list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout_message_fragment, container, false);
        message_list = (ListView) view.findViewById(R.id.message_list);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        arrayList = new ArrayList<>();
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        messageAdapter = new MessageAdapter(getActivity(), arrayList);
        message_list.setAdapter(messageAdapter);

        message_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), MessageShow.class));
            }
        });

    }
}
