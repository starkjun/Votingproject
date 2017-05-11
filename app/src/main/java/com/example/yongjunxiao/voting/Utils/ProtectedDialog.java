package com.example.yongjunxiao.voting.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yongjunxiao.voting.R;

/**
 * Created by yongjun.xiao on 17-4-24.
 */

public class ProtectedDialog {

    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private EditText passwd;
    private Button ok_btn;
    private Button cancel_btn;
    private Context context;
    private LayoutInflater inflater;
    private View view;
    private OnOkListener onOkListener;
    private OnCancelListener cancelListener;

    public ProtectedDialog(Context context) {
        this.context = context;
        initView();
    }

    private void initView() {
        inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.layout_protected_dialog, null);

        passwd = (EditText) view.findViewById(R.id.password);
        ok_btn = (Button) view.findViewById(R.id.btn_ok);
        cancel_btn = (Button) view.findViewById(R.id.btn_cancel);

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOkListener.onclick();
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelListener.onclick();
            }
        });

        builder = new AlertDialog.Builder(context);
        alertDialog = builder.create();
        alertDialog.setView(view);
        alertDialog.setCanceledOnTouchOutside(false);
    }


    public void show() {
        alertDialog.show();
    }

    public void dismiss() {
        alertDialog.dismiss();
    }

    public String getInputPSW() {
        return passwd.getText().toString();
    }

    public void setOnOkListener(OnOkListener onOkListener) {
        this.onOkListener = onOkListener;
    }

    public void setOnCancelListener(OnCancelListener cancelListener) {
        this.cancelListener = cancelListener;
    }

    public interface OnOkListener {
        void onclick();
    }

    public interface OnCancelListener {
        void onclick();
    }

}
