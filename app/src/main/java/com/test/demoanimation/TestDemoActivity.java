package com.test.demoanimation;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Administrator on 2017/8/17.
 */
public class TestDemoActivity  extends BaseOverActivity {
    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_test_demo;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    public static void start(Activity activity) {
        Intent  intent=new Intent(activity,TestDemoActivity.class);
        activity.startActivity(intent);
    }
}
