package com.test.demoanimation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

/**
 * Created by Administrator on 2017/8/16.
 */

public class CircularRevealMainActivity extends BaseOverActivity  {

    private Activity activity;

    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_circular_reveal_main;
    }

    @Override
    protected void initPresenter() {

    }

    public   static   void  start(Context  context)
    {
        Intent  intent  =new Intent(context,CircularRevealMainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        activity = CircularRevealMainActivity.this;
        final FloatingActionButton fb = (FloatingActionButton) findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions  activityOptions=ActivityOptions.makeSceneTransitionAnimation(activity,fb,fb.getTransitionName());
                Intent  intent=new Intent(activity,CircularRevealPaoZaActivity.class);
                activity.startActivity(intent,activityOptions.toBundle());
            }
        });

    }
}
