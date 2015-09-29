package com.me.daily.ui.adapter.item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.me.daily.core.bean.TopNews;
import com.me.daily.ui.adapter.TopNewsAdapter;
import com.me.daily.ui.adapter.holder.TopNewsViewHolder;

/**
 * Created by wds on 9/24/2015.
 */
public class TopNewsItem extends MultipleTypesAdapterItem<TopNews> {

    public TopNewsItem(int viewType, TopNews data) {
        super(viewType, data);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, Context context) {
        ((TopNewsViewHolder) holder).viewPager.setAdapter(new TopNewsAdapter(data, context));
    }
}
