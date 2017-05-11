package com.example.yongjunxiao.voting.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yongjunxiao.voting.R;

/**
 * Created by yongjun.xiao on 17-4-25.
 */

public class NewsFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout_news_fragment,container,false);

        return view;
    }
}
