package com.pop.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.zhs.popmenu.PopMenuManager;

public class MainActivity extends AppCompatActivity {

    private LinearLayout rlroot;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlroot= (LinearLayout) findViewById(R.id.rlroot);
        toast= Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopMenuManager.getInstance().init(MainActivity.this, new PopMenuManager.Builder()
                        .setFirstContent("相机")
                        .setSecendContent("相册")
                        .setThirdtContent("取消")
                        .setFirstColor("#FF4949").build(), new PopMenuManager.OnViewClickListener() {
                    @Override
                    public void onMenuClick(int flag) {

                        switch (flag){
                            case PopMenuManager.MENU_FIRST:
                                toast.setText("1");
                                toast.show();
                                break;
                            case PopMenuManager.MENU_SECEND:
                                toast.setText("2");
                                toast.show();
                                break;
                            case PopMenuManager.MENU_THIRD:
                                toast.setText("3");
                                toast.show();
                                break;
                        }
                    }
                }).showOutMenu(rlroot);
            }
        });
    }
}
