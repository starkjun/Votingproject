package com.example.yongjunxiao.voting.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.yongjunxiao.voting.Activity.GroupList;
import com.example.yongjunxiao.voting.Activity.MessageShow;
import com.example.yongjunxiao.voting.Adapter.ContactsFragmentAdapter;
import com.example.yongjunxiao.voting.R;

/**
 * Created by yongjun.xiao on 17-4-25.
 */

public class ContactsFragment extends Fragment {

    private View view;
    private ListView listView;
    private RelativeLayout group;
    private ContactsFragmentAdapter contactsFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout_contacts_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.listview);
        group = (RelativeLayout) view.findViewById(R.id.group_line);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contactsFragmentAdapter = new ContactsFragmentAdapter(getActivity());

        listView.setAdapter(contactsFragmentAdapter);
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GroupList.class));
            }
        });

    }
}
