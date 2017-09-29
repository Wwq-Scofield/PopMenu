package com.zhs.popmenu;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2017/9/29.
 */

public class CommenDialogManager {
    public static final int NEGATIVE_BTN = 1;
    public static final int POSITIVE_BTN = 2;
    private Context mContext;
    private String firstContent, firstColor;
    private String secendContent, secendColor;
    private String mainContent,title;
    private onCommonMenuClick mlistener;
    private static PopMenuManager manager;
    private CommonDialog backdialog;
    public CommenDialogManager() {

    }
    public PopMenuManager init(Context context, Builder builder, onCommonMenuClick listener) {
        if (builder == null || context == null) {
            throw new RuntimeException("builder or context is null");
        }
        this.mContext = context;
        this.mlistener = listener;
        this.firstContent = builder.firstContent;
        this.secendContent = builder.secendContent;
        this.firstColor = builder.firstColor;
        this.secendColor = builder.secendColor;
        this.mainContent=builder.mainContent;
        this.title=builder.title;
        return manager;
    }

    public static class Builder {
        public String firstContent, firstColor;
        public String secendContent, secendColor;
        public String thirdContent, thirdColor;
        public String mainContent,title;

        public CommenDialogManager.Builder setFirstContent(String content) {
            this.firstContent = content;
            return this;
        }

        public CommenDialogManager.Builder setSecendContent(String content) {
            this.secendContent = content;
            return this;
        }

        public CommenDialogManager.Builder setFirstColor(String color) {
            this.firstColor = color;
            return this;
        }
        public CommenDialogManager.Builder setSecendColor(String color) {
            this.secendColor = color;
            return this;
        }
        public CommenDialogManager.Builder setTitle(String title) {
            this.title= title;
            return this;
        }
        public CommenDialogManager.Builder build() {
            return this;
        }
    }
    public void showCommnonialog(Context context){
        if(context instanceof Activity){
            backdialog = new CommonDialog(context);
            backdialog.setNegativeContent(firstContent);
            backdialog.setNegativeColor(firstColor);
            backdialog.setPositiveContent(secendContent);
            backdialog.setPositiveColor(secendColor);
            backdialog.setContent(mainContent);
            backdialog.setTitle(title);
            backdialog.setOnNegativeListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    backdialog.dismiss();
                    if(mlistener!=null){
                        mlistener.onBtnClick(NEGATIVE_BTN);
                    }
                }
            });
            //退出的dialog
            backdialog.setOnPositiveListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    backdialog.dismiss();
                    if(mlistener!=null){
                        mlistener.onBtnClick(POSITIVE_BTN);
                    }
                }
            });
            backdialog.getWindow().setLayout((int) context.getResources().getDimension(R.dimen.with),
                    (int) context.getResources().getDimension(R.dimen.hight));
            backdialog.show();
        }else{
            throw  new RuntimeException("context is not activiy");
        }

    }

    public interface  onCommonMenuClick{
        void onBtnClick(int  position);
    }
}
