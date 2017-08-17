package com.test.demoanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/9.
 */

public class LoadImgActivity extends BaseOverActivity {


    private String img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("onCreate","img=>"+img);
    }

    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_load_img;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {

        img = getIntent().getStringExtra("img");
        Banner load_img = (Banner) findViewById(R.id.banner);
        Log.i("onCreate","img=>"+img);
        List<String> images  =new ArrayList<>();
        images.add(img);
        setDataAndStart(images);


    }


    /**
     * 初始化轮播图，和设置轮播图数据
     *
     * @param images
     */
    public void setDataAndStart(List<String> images) {
        Banner banner = (Banner) findViewById(R.id.banner);
//        //设置banner样式
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播时间
        banner.setDelayTime(3000);

        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

}
