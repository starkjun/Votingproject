package com.example.yongjunxiao.voting.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yongjunxiao.voting.R;

/**
 * Created by yongjun.xiao on 17-4-21.
 */

public class MyDialog {
    private Context context;
    private EditText modified_content;
    private Button btn_ok;
    private Button btn_cancle;
    private TextView title;
    private View mydialog_view;
    private LayoutInflater inflater;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private onOkListener okListener;
    private onCancelListener cancleListener;

    public MyDialog(Context context) {
        this.context = context;
        initView();


    }

    private void initView() {
        inflater = LayoutInflater.from(context);
        mydialog_view = inflater.inflate(R.layout.layout_mydialog, null);

        modified_content = (EditText) mydialog_view.findViewById(R.id.modified_content);
        btn_ok = (Button) mydialog_view.findViewById(R.id.btn_ok);
        btn_cancle = (Button) mydialog_view.findViewById(R.id.btn_cancel);
        title = (TextView) mydialog_view.findViewById(R.id.title);
        builder = new AlertDialog.Builder(context);
        alertDialog = builder.create();
        alertDialog.setView(mydialog_view);
        alertDialog.setCanceledOnTouchOutside(false);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okListener.onClick();
            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancleListener.onClick();
            }
        });


    }


    public String getEditTextString() {
        return modified_content.getText().toString();
    }

    public void clearEditText() {
        modified_content.setText("");
    }

    public void setEditTexthint() {
        modified_content.setVisibility(View.INVISIBLE);
    }

    public void setEditTextVisible() {
        modified_content.setVisibility(View.VISIBLE);
    }

    public void setCanceledOnTouchOutside(boolean b){
        alertDialog.setCanceledOnTouchOutside(b);
    }

    public void setTitle(String s) {
        title.setText(s);
    }

    public void show() {
        alertDialog.show();
    }

    public void dismiss() {
        alertDialog.dismiss();
    }

    public void setOnOkListener(onOkListener onOkListener) {
        this.okListener = onOkListener;
    }

    public void setOnCancleListener(onCancelListener cancleListener) {
        this.cancleListener = cancleListener;
    }

    public interface onOkListener {
        void onClick();
    }

    public interface onCancelListener {
        void onClick();
    }
}
