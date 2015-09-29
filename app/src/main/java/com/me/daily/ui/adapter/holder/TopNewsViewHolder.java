package com.me.daily.ui.adapter.holder;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.me.daily.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wds on 9/22/2015.
 */
public class TopNewsViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.top_news)
    public ViewPager viewPager;


    public TopNewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
