package com.me.daily.ui.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.me.daily.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wds on 9/22/2015.
 */
public class DailyNewsItemViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.image)
    public ImageView image;
    @Bind(R.id.title)
    public TextView title;


    public DailyNewsItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
