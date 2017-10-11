package com.zhs.popmenu;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Description:
 * Copyright  : Copyright (c) 2017
 * Author     : wwq
 * Date       : 2017/09/29 14:09
 */
public class CommonDialog extends Dialog {

    private TextView positiveButton, negativeButton;
    private TextView tvContent,tvTitle;
    public CommonDialog(Context context) {
        super(context, R.style.CustomDialog);
        setCustomDialog();
    }
    private void setCustomDialog() {
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.layout_dialog_easy, null);
        positiveButton = (TextView) mView.findViewById(R.id.tv_positive);
        negativeButton = (TextView) mView.findViewById(R.id.tv_negative);
        tvContent= (TextView) mView.findViewById(R.id.tv_desc);
        tvTitle= (TextView) mView.findViewById(R.id.tv_title);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
        super.setContentView(mView);
    }

    public void setOnDisMiss(OnDismissListener listener){
        setOnDismissListener(listener);
    }
    /**
     * 监听器
     *
     * @param listener
     */
    public void setOnPositiveListener(View.OnClickListener listener) {
        positiveButton.setOnClickListener(listener);
    }

    public void setNegativeContent(String content){
        if(!TextUtils.isEmpty(content)){
            negativeButton.setText(content);
        }
    }

    public void setPositiveContent(String content){
        if(!TextUtils.isEmpty(content)){
            positiveButton.setText(content);
        }
    }
    public void setContent(String content){
        if(!TextUtils.isEmpty(content)){
            tvContent.setText(content);
        }
    }
    public void setTitle(String content){
        if(!TextUtils.isEmpty(content)){
            tvTitle.setText(content);
        }
    }
    /**
     * 监听器
     *
     * @param listener
     */
    public void setOnNegativeListener(View.OnClickListener listener) {
        negativeButton.setOnClickListener(listener);
    }

    public void setNegativeColor(String negativeColor) {
        if(!TextUtils.isEmpty(negativeColor)){
            this.negativeButton.setTextColor(Color.parseColor(negativeColor));
        }

    }
    public void setPositiveColor(String positiveColor) {
        if(!TextUtils.isEmpty(positiveColor)){
            this.positiveButton.setTextColor(Color.parseColor(positiveColor));
        }
    }

}
