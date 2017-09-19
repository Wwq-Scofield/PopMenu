package com.zhs.popmenu;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2017/9/19.
 */

public class PopMenuManager {
    public static final int MENU_FIRST=1;
    public static final int MENU_SECEND=2;
    public static final int MENU_THIRD=3;
    private PopupWindow window;
    private Context mContext;
    private String firstContent;
    private String secendContent;
    private String thirdContent;
    private OnViewClickListener mlistener;
    private static  PopMenuManager manager;
    public static PopMenuManager getInstance(){
        if(manager==null){
            manager=new PopMenuManager();
        }
        return manager;
    }
    public PopMenuManager init(Context context, Builder builder,OnViewClickListener listener) {
        if(builder==null||context==null){
            throw new RuntimeException("builder or context is null");
        }
        this.mContext = context;
        this.mlistener=listener;
        this.firstContent = builder.firstContent;
        this.secendContent = builder.secendContent;
        this.thirdContent = builder.thirdContent;
        return manager;
    }
    public static class Builder {
        public String firstContent;
        public String secendContent;
        public String thirdContent;

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
        Button btn1 = (Button) view.findViewById(R.id.menu_first);
        Button btn2 = (Button) view.findViewById(R.id.menu_secend);
        Button btn3 = (Button) view.findViewById(R.id.menu_third);
        Log.d("wwq","firstContent="+firstContent+" secendContent="+secendContent+" thirdContent="+thirdContent);
        btn1.setText(firstContent);
        btn2.setText(secendContent);
        btn3.setText(thirdContent);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                if(mlistener!=null){
                    mlistener.onMenuClick(MENU_FIRST);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                if(mlistener!=null){
                    mlistener.onMenuClick(MENU_SECEND);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                if(mlistener!=null){
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

    public interface OnViewClickListener{
        void onMenuClick(int flag);
    }
}

