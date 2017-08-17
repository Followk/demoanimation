package com.test.demoanimation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/15.
 */

public class ActivityOptionsAnimationSetActivity extends BaseOverActivity implements View.OnClickListener {

    private TextView explode_tv;
    private Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_activity_options_animation_set;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        this.activity = ActivityOptionsAnimationSetActivity.this;
        explode_tv = (TextView) findViewById(R.id.explode_tv);
        explode_tv.setOnClickListener(this);


        TextView slide_tv = (TextView) findViewById(R.id.slide_tv);
        slide_tv.setOnClickListener(this);


        TextView slide_reenter_tv = (TextView) findViewById(R.id.slide_reenter_tv);
        slide_reenter_tv.setOnClickListener(this);


        TextView  circular_reveal_tv= (TextView) findViewById(R.id.circular_reveal_tv);
        circular_reveal_tv.setOnClickListener(this);


        TextView  click_list_item_tv  = (TextView) findViewById(R.id.click_list_item_tv);
        click_list_item_tv.setOnClickListener(this);


        TextView  view_tv= (TextView) findViewById(R.id.view_tv);
        view_tv.setOnClickListener(this);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityOptionsAnimationSetActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            /**
             * 从A Activity 跳转到B  Activity   如果不给B  Activity  设置 退出的时候的动画 ，那么在B  Activity  退出的时候进入A
             * Activity  那么将会反过来执行 A -》 B 的动画,
             * R.id.explode_tv
             * R.id.slide_tv
             * 两个点击事件就可以看到这种效果
             */
            case R.id.explode_tv:


                setWindsExitAnimations();

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ActivityOptionsAnimationSetActivity.this);
                activity.startActivity(new Intent(ActivityOptionsAnimationSetActivity.this, ExplodeActivity.class), options.toBundle());

                break;

            case R.id.slide_tv:

                setWindsSlideExitAnimations();
                ActivityOptions options1 = ActivityOptions.makeSceneTransitionAnimation(ActivityOptionsAnimationSetActivity.this);
                activity.startActivity(new Intent(ActivityOptionsAnimationSetActivity.this, SlideActivity.class), options1.toBundle());
                break;

            case R.id.slide_reenter_tv:
                setWindsSlideExitAnimations();
                setWindsReenterTransition();
                ActivityOptionsCompat options2 = ActivityOptionsCompat.makeSceneTransitionAnimation(ActivityOptionsAnimationSetActivity.this);
                activity.startActivity(new Intent(ActivityOptionsAnimationSetActivity.this, SlideReenterTransitionActivity.class), options2.toBundle());
                break;

            case R.id.circular_reveal_tv:
                CircularRevealMainActivity.start(activity);
                break;
            case R.id.click_list_item_tv:
                TestDemoAnimationActivity.start(activity);
                break;
            case R.id.view_tv:
                TestDemoActivity.start(activity);
            default:
                break;
        }
    }

    private void setWindsSlideExitAnimations() {

        //Gravity.TOP  从上往下滚动
        //Gravity.BOTTOM  从下往上
        //Gravity.LEFT  从左滚动过来
        Slide slide = new Slide(Gravity.LEFT);
        slide.setDuration(500);
        slide.setInterpolator(new AccelerateDecelerateInterpolator());
        getWindow().setExitTransition(slide);
    }


    /**
     * 设置窗口  离开动画
     * <p>
     * 测试证明  这个方法在这个Activity 跳转之前设置都有效果
     */
    public void setWindsExitAnimations() {
        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setExitTransition(explode);
    }


    public void setWindsReenterTransition() {

        //代码设置
//        Fade explode = new Fade();
//        explode.setDuration(300);
//        getWindow().setReenterTransition(explode);


        //xml设置
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
        getWindow().setReenterTransition(transition);
    }
}
