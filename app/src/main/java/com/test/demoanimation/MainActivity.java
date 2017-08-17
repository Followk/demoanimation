package com.test.demoanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseOverActivity implements View.OnClickListener {

    private TextView tv_1,tv_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        setListener();

    }

    private void setListener() {
        tv_1.setOnClickListener(this);
        tv_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_1:
                TestDemoAnimationActivity.start(this);
                break;
            case R.id.tv_2://ActivityOptions动画

                ActivityOptionsAnimationSetActivity.start(this);
                break;
            default:
                break;
        }
    }
}
