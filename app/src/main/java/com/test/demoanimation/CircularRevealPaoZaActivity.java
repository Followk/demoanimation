package com.test.demoanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/8/16.
 */
public class CircularRevealPaoZaActivity  extends BaseOverActivity {

    private RelativeLayout main_rl;
    private FloatingActionButton shared_fb;
    private Activity activity;
    private RelativeLayout context_rl;

    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_circular_reveal_pao_za;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    @TargetApi(21)
    protected void initView() {
        activity = this;
        findViewById();
        setSharedtTansition();
    }

    private void findViewById() {
        main_rl = (RelativeLayout) findViewById(R.id.main_rl);
        shared_fb = (FloatingActionButton) findViewById(R.id.shared_fb);
        context_rl = (RelativeLayout) findViewById(R.id.context_rl);
    }

    private void setSharedtTansition() {
        //这段就是给共享元素设置了一个动画过渡
        Transition  transition= TransitionInflater.from(this).inflateTransition(R.transition.arc_motion);
        getWindow().setSharedElementEnterTransition(transition);
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                //共享元素过渡动画执行完毕后，开始执行爆炸动画效果
               showCircularReveal();
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
    }

    private void showCircularReveal() {
        int cx = (main_rl.getLeft() + main_rl.getRight()) / 2;
        int cy = (main_rl.getTop() + main_rl.getBottom()) / 2;

        float finalRadius = (float) Math.hypot(main_rl.getWidth(), main_rl.getHeight());

        // 设置圆形显示动画
        Animator anim = ViewAnimationUtils.createCircularReveal(main_rl, cx, cy, shared_fb.getWidth()/2, finalRadius);
        anim.setDuration(300);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                main_rl.setVisibility(View.VISIBLE);
                setInitAnimation();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                main_rl.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorAccent));
            }
        });
        anim.start();
    }


    public  void   setInitAnimation()
    {
        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        animation.setDuration(300);
        context_rl.startAnimation(animation);
        context_rl.setVisibility(View.VISIBLE);
    }
}
