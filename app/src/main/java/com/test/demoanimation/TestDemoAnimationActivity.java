package com.test.demoanimation;

import android.content.Context;
import android.content.Intent;
import android.view.Window;

import com.test.demoanimation.presenter.TestDemoAnimationPresenter;
import com.test.demoanimation.view.TestDemoAnimationViewHolder;

/**
 * Created by Administrator on 2017/8/9.
 */

public class TestDemoAnimationActivity extends BaseOverActivity {

    private TestDemoAnimationPresenter presenter;

    public static  void  start(Context context)
    {
        Intent intent=new Intent(context,TestDemoAnimationActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_test_demo_animation1;
    }

    @Override
    protected void initPresenter() {
        TestDemoAnimationViewHolder viewHolder=new  TestDemoAnimationViewHolder(rootView,this);
        presenter = new TestDemoAnimationPresenter(viewHolder);
    }

    @Override
    protected void initView() {
        presenter.getRectViewData();
    }
}
