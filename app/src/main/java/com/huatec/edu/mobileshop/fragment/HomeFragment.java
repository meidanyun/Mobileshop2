package com.huatec.edu.mobileshop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.common.BaseFragment;

public class HomeFragment extends BaseFragment {
    public int getContentViewId(){
        return R.layout.fragment_home;
    }

    private View view;
    private ProgressBar pro1;
    private ToggleButton btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_home,null);
        btn = (ToggleButton)view.findViewById(R.id.button_home1);
        pro1 = (ProgressBar)view.findViewById(R.id.progress_home1);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = btn.isChecked();
                if (checked){
                    pro1.setVisibility(ProgressBar.GONE);
                }else {
                    pro1.setVisibility(ProgressBar.VISIBLE);
                }
            }
        });
    }
}


