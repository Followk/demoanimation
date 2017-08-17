package com.test.demoanimation.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test.demoanimation.R;
import com.test.demoanimation.mode.ImageAndTextInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/9.
 */
public class TestDemoAnimationViewAdapter extends RecyclerView.Adapter {
    private final Activity context;
    private ArrayList<ImageAndTextInfo> adaterData;
    private ItemOnClickListener listener;

    public TestDemoAnimationViewAdapter(Activity context) {
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item_text, null);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder  viewHolder=   (MyViewHolder)holder;
        final ImageAndTextInfo  andTextInfo= adaterData.get(position);
        viewHolder.tv_context.setText(andTextInfo.getContext());
        Glide.with(context).load(andTextInfo.getImgUrl()).into(viewHolder.img);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null)
                {
                    listener.onItemClick(v,andTextInfo);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return adaterData!=null?adaterData.size():0;
    }

    public void setAdaterData(ArrayList<ImageAndTextInfo> adaterData) {
        this.adaterData = adaterData;
        notifyDataSetChanged();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        public final ImageView img;
        public final TextView tv_context;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            tv_context = (TextView) itemView.findViewById(R.id.tv_context);


        }
    }


    public  void setItemOnClickListener(ItemOnClickListener  listener)
    {
        this.listener=listener;
    }

    public interface ItemOnClickListener
    {
       void  onItemClick(View v, ImageAndTextInfo andTextInfo);
    }
}
