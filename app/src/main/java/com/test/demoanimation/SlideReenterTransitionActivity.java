package com.test.demoanimation;

import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/8/15.
 */
public class SlideReenterTransitionActivity    extends BaseOverActivity {
    @Override
    protected int getViewLayoutId() {
        return  R.layout.activity_explode;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        setWindsEnterAnimations();
        setWindsReturnTransition();
    }



    //进来动画
    private void setWindsEnterAnimations() {
//        Fade slide=new Fade();
//        slide.setDuration(100);

        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
        getWindow().setEnterTransition(transition);
    }


    //页面退出动画
    private void setWindsReturnTransition() {
//        Slide slide=new Slide(Gravity.RIGHT);
//        slide.setDuration(300);
//        slide.setInterpolator(new AccelerateDecelerateInterpolator());
        //       getWindow().setReturnTransition(slide);

        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
        getWindow().setReturnTransition(transition);
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            finishAfterTransition();//退出动画一定要这么写，要不然会出现bug
            //补充，就算加了上面的动画在某些时候，也会出现返回上一个页面的时候出现白色页面，或者快速点击A  界面，B界面返回，重复做这个操作，出现白色页面概率很高

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
