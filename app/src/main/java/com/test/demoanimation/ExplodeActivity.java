package com.test.demoanimation;

import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.KeyEvent;

/**
 * Created by Administrator on 2017/8/15.
 */
public class ExplodeActivity  extends BaseOverActivity {
    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_explode;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {

        setWindsEnterAnimations();
    }

    private void setWindsEnterAnimations() {
        Fade   slide=new Fade();
        slide.setDuration(300);
        getWindow().setEnterTransition(slide);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            finishAfterTransition();//退出动画一定要这么写，要不然会出现bug
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
