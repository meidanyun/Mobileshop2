package com.huatec.edu.mobileshop.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.common.BaseActivity;
import com.huatec.edu.mobileshop.common.MobileShopAPP;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;


import static android.hardware.camera2.params.BlackLevelPattern.COUNT;

public class AdActivity extends BaseActivity {
    private TextView tv_skip;

    @Override
    public int getContentViewId(){
        return R.layout.activity_ad;
    }

    @Override
    protected void initView(){
        super.initView();
        tv_skip = (TextView)findViewById(R.id.tv_skip);
        tv_skip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                skip();
            }
         });
        ImageView imageView = (ImageView) findViewById(R.id.iv_image);
        String url = "http://10.37.59.210/MobileShop/img/ad/new_ad_img.jpg";
        ImageLoader.getInstance().displayImage(url,imageView,new ImageLoadingListener(){
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                MobileShopAPP.handler.post(jumpTread);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage){
                MobileShopAPP.handler.post(jumpTread);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view){
                MobileShopAPP.handler.post(jumpTread);
            }
        });

   }

   private void skip(){
       Intent intent = new Intent(AdActivity.this,MainActivity.class);
       startActivity(intent);
       finish();
       c_count = Count;
       MobileShopAPP.handler.removeCallbacks(jumpTread);
   }

   private static final String SKIP_TEXT = "点击跳过 %d";
   private final static int Count = 5;
   private final static int DELAYED = 1000;
   private int c_count = COUNT;

   private Runnable jumpTread = new Runnable() {
       @Override
       public void run() {
           if (c_count <= 0){
               skip();
           }else{
               tv_skip.setText(String.format(SKIP_TEXT,c_count));
               c_count--;
               MobileShopAPP.handler.postDelayed(jumpTread,DELAYED);
           }
       }
   };

}