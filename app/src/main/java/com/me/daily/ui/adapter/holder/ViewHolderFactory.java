package com.me.daily.ui.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.me.daily.R;

/**
 * Created by wds on 9/24/2015.
 */
public class ViewHolderFactory {

    public static RecyclerView.ViewHolder getViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case ItemViewType.TYPE_ITEM_HEADER:
                holder = new DailyNewsHeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily_news_header, parent, false));
                break;
            case ItemViewType.TYPE_ITEM:
                holder = new DailyNewsItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily_news, parent, false));
                break;
            case ItemViewType.TYPE_TOP_NEWS:
                holder = new TopNewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.top_news, parent, false));
                break;
        }

        return holder;
    }
}
