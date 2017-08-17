package com.test.demoanimation.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.test.demoanimation.LoadImgActivity;
import com.test.demoanimation.R;
import com.test.demoanimation.TestDemoAnimationActivity;
import com.test.demoanimation.mode.ImageAndTextInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/9.
 */

public class TestDemoAnimationViewHolder implements TestDemoAnimationView, TestDemoAnimationViewAdapter.ItemOnClickListener {
    private final View rootView;
    private final Activity context;
    private RecyclerView recyclerView;
    private TestDemoAnimationViewAdapter viewAdapter;
    private final TestDemoAnimationViewHolder animationActivity;

    public TestDemoAnimationViewHolder(View rootView, TestDemoAnimationActivity context) {
        this.rootView=rootView;
        this.context=context;
        animationActivity = this;
        findViewById();
    }

    private void findViewById() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rcView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));

        viewAdapter = new TestDemoAnimationViewAdapter(context);

        viewAdapter.setItemOnClickListener(animationActivity);
        recyclerView.setAdapter(viewAdapter);
    }

    @Override
    public void setRectViewData(ArrayList<ImageAndTextInfo> andTextInfos) {
        viewAdapter.setAdaterData(andTextInfos);
    }


    @Override
    public void onItemClick(View v, ImageAndTextInfo andTextInfo) {

       ImageView   imgIv= (ImageView) v.findViewById(R.id.img);
        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(context,imgIv,imgIv.getTransitionName());
        Intent  intent=new Intent(v.getContext(),LoadImgActivity.class);
        intent.putExtra("img",andTextInfo.getImgUrl());
       context.startActivity(intent,options.toBundle());
    }
}
