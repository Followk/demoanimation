package com.test.demoanimation.presenter;

import android.os.Handler;

import com.test.demoanimation.GetDateUtil;
import com.test.demoanimation.mode.ImageAndTextInfo;
import com.test.demoanimation.view.TestDemoAnimationViewHolder;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/9.
 */

public class TestDemoAnimationPresenter implements ITestDemoAnimationPresenter {
    private final TestDemoAnimationViewHolder viewHolder;

    public TestDemoAnimationPresenter(TestDemoAnimationViewHolder viewHolder) {
        this.viewHolder=viewHolder;
    }

    @Override
    public void getRectViewData() {
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               ArrayList<ImageAndTextInfo>   andTextInfos=GetDateUtil.getData();
               viewHolder.setRectViewData(andTextInfos);
           }
       },1000);
    }
}
