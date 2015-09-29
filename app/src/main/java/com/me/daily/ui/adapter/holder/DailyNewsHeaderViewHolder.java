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
public class DailyNewsHeaderViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.date)
    public TextView date;


    public DailyNewsHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
