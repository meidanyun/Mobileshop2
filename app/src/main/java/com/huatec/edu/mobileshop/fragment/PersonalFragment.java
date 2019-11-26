package com.huatec.edu.mobileshop.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.activity.ChangePwdActivity;
import com.huatec.edu.mobileshop.activity.LoginActivity;
import com.huatec.edu.mobileshop.activity.MyAddressActivity;
import com.huatec.edu.mobileshop.activity.MyCollectActivity;
import com.huatec.edu.mobileshop.activity.MyOrderActivity;
import com.huatec.edu.mobileshop.common.BaseFragment;
import com.huatec.edu.mobileshop.utils.SystemConfig;
import com.nostra13.universalimageloader.core.ImageLoader;

public class PersonalFragment extends BaseFragment {
    @Override
    public int getContentViewId(){
        return R.layout.fragment_personal;
    }

    @Override
    protected void initView(View view){
        super.initView(view);
        resetUI();
    }

    private void resetUI(){
        if(SystemConfig.isLogin()){
            personal_for_login.setVisibility(View.VISIBLE);
            personal_for_not_login.setVisibility(View.GONE);
            person_logout_layout.setVisibility(View.VISIBLE);

            ImageLoader.getInstance().displayImage(SystemConfig.getLoginUserHead(),user_img_view);
            user_name.setText(SystemConfig.getLoginUserName());
            user_level.setText(SystemConfig.getLoginUserEmail());
        }else{
            personal_for_login.setVisibility(View.GONE);
            personal_for_not_login.setVisibility(View.VISIBLE);
            person_logout_layout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode== Activity.RESULT_OK){
            resetUI();

            Intent intent = new Intent();
            if(requestCode==1000){
                }else if(requestCode==1001){
                intent.setClass(getActivity(),MyOrderActivity.class);
                startActivity(intent);
            }else if(requestCode==1002){
                intent.setClass(getActivity(),MyCollectActivity.class);
                startActivity(intent);
            }else if (requestCode==1003){
                intent.setClass(getActivity(),MyAddressActivity.class);
                startActivity(intent);
            }else if (requestCode==1004){
                intent.setClass(getActivity(),ChangePwdActivity.class);
                startActivity(intent);
            }
        }
    }

    private View view;
    private Button btn;

    RelativeLayout personal_for_login;
    ImageView user_img_view;
    TextView user_name;
    TextView user_level;
    RelativeLayout personal_for_not_login;
    RelativeLayout person_logout_layout;

    Button personal_login;
    RelativeLayout my_order;
    RelativeLayout my_collect;
    RelativeLayout my_address;
    RelativeLayout my_account;
    TextView my_account_text1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_personal,null);

        personal_for_login=(RelativeLayout)view.findViewById(R.id.personal_for_login);
        user_img_view=(ImageView)view.findViewById(R.id.user_img_view);
        user_name=(TextView)view.findViewById(R.id.user_name);
        user_level=(TextView)view.findViewById(R.id.user_level);
        personal_for_not_login=(RelativeLayout)view.findViewById(R.id.personal_for_not_login);
        person_logout_layout=(RelativeLayout)view.findViewById(R.id.person_logout_layout);

        personal_login=(Button)view.findViewById(R.id.personal_login);
        my_order=(RelativeLayout)view.findViewById(R.id.person_my_order);
        my_collect=(RelativeLayout)view.findViewById(R.id.my_collect);
        my_address=(RelativeLayout) view.findViewById(R.id.my_address);
        my_account=(RelativeLayout) view.findViewById(R.id.my_account);
        my_account_text1=(TextView)view.findViewById(R.id.my_account_text1);

        resetUI();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        personal_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "登录", Toast.LENGTH_LONG);
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(intent, 1000);
            }
        });
        my_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "订单", Toast.LENGTH_LONG);
                if (SystemConfig.isLogin()) {
                    startActivity(new Intent(getActivity(), MyOrderActivity.class));
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(intent, 1001);
                }
            }
        });
        my_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "收藏", Toast.LENGTH_LONG);
                if (SystemConfig.isLogin()) {
                    startActivity(new Intent(getActivity(), MyCollectActivity.class));
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(intent, 1002);
                }
            }
        });
        my_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "地址", Toast.LENGTH_LONG);
                if (SystemConfig.isLogin()) {
                    startActivity(new Intent(getActivity(), MyAddressActivity.class));
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(intent, 1003);
                }
            }
        });
        my_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "密码", Toast.LENGTH_LONG);
                if (SystemConfig.isLogin()) {
                    startActivity(new Intent(getActivity(), ChangePwdActivity.class));
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(intent, 1004);
                }
            }
        });
        my_account_text1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SystemConfig.logout();
                resetUI();
            }
        });
    }
}
