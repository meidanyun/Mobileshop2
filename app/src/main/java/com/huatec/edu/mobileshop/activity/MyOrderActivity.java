package com.huatec.edu.mobileshop.activity;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.common.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MyOrderActivity extends BaseActivity {

//    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int getContentViewId() { return R.layout.activity_my_order; }

    @Override
    protected void initView() {
        super.initView();
        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("我的订单");


        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
    }

//    @OnClick(R.id.iv_back)
    void close(){ finish();}
}
