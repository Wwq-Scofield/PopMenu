package com.zhs.popmenu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/19.
 */

public class PopMenuManager {
    public static final int MENU_FIRST = 1;
    public static final int MENU_SECEND = 2;
    public static final int MENU_THIRD = 3;
    private PopupWindow window;
    private Context mContext;
    private String firstContent, firstColor;
    private String secendContent, secendColor;
    private String thirdContent, thirdColor;
    private OnViewClickListener mlistener;
    private static PopMenuManager manager;

    public PopMenuManager() {

    }
    public PopMenuManager init(Context context, Builder builder, OnViewClickListener listener) {
        if (builder == null || context == null) {
            throw new RuntimeException("builder or context is null");
        }
        this.mContext = context;
        this.mlistener = listener;
        this.firstContent = builder.firstContent;
        this.secendContent = builder.secendContent;
        this.thirdContent = builder.thirdContent;
        this.firstColor = builder.firstColor;
        this.secendColor = builder.secendColor;
        this.thirdColor = builder.thirdColor;
        return manager;
    }

    public static class Builder {
        public String firstContent, firstColor;
        public String secendContent, secendColor;
        public String thirdContent, thirdColor;

        public Builder setFirstContent(String content) {
            this.firstContent = content;
            return this;
        }

        public Builder setSecendContent(String content) {
            this.secendContent = content;
            return this;
        }

        public Builder setThirdtContent(String content) {
            this.thirdContent = content;
            return this;
        }

        public Builder setFirstColor(String color) {
            this.firstColor = color;
            return this;
        }

        public Builder setSecendColor(String color) {
            this.secendColor = color;
            return this;
        }

        public Builder setThirdColor(String color) {
            this.thirdColor = color;
            return this;
        }

        public Builder build() {
            return this;
        }
    }

    public void showOutMenu(View locationView) {
        LayoutInflater layoutIn = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutIn.inflate(R.layout.layout_pop_menu, null);
        LinearLayout newpopwindow = (LinearLayout) view.findViewById(R.id.popwindow);
        newpopwindow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (window != null && window.isShowing()) {
                    window.dismiss();
                    window = null;
                }
            }
        });
        TextView btn1 = (TextView) view.findViewById(R.id.menu_first);
        TextView btn2 = (TextView) view.findViewById(R.id.menu_secend);
        TextView btn3 = (TextView) view.findViewById(R.id.menu_third);
        Log.d("wwq", "firstColor=" + firstColor  );
        Log.d("wwq", "secendColor=" + secendColor  );
        if (!TextUtils.isEmpty(firstColor)) {
            btn1.setTextColor(Color.parseColor(firstColor));
        }
        if (!TextUtils.isEmpty(secendColor)) {
            btn2.setTextColor(Color.parseColor(secendColor));
        }

        if (!TextUtils.isEmpty(thirdColor)) {
            btn3.setTextColor(Color.parseColor(thirdColor));
        }
        if(!TextUtils.isEmpty(firstContent)){
            btn1.setVisibility(View.VISIBLE);
            btn1.setText(firstContent);
        }else{
            btn1.setVisibility(View.GONE);
        }
        if(!TextUtils.isEmpty(secendContent)){
            btn2.setVisibility(View.VISIBLE);
            btn2.setText(secendContent);
        }else{
            btn2.setVisibility(View.GONE);
        }
        btn3.setText(TextUtils.isEmpty(secendContent)?"取消":thirdContent);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                if (mlistener != null) {
                    mlistener.onMenuClick(MENU_FIRST);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                if (mlistener != null) {
                    mlistener.onMenuClick(MENU_SECEND);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                if (mlistener != null) {
                    mlistener.onMenuClick(MENU_THIRD);
                }
            }
        });
        if (window == null) {
            window = new PopupWindow(view, android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT, true);
            window.setBackgroundDrawable(new BitmapDrawable());
        }
        window.showAtLocation(locationView, Gravity.BOTTOM, 0, 0);
    }

    public interface OnViewClickListener {
        void onMenuClick(int flag);
    }

}

