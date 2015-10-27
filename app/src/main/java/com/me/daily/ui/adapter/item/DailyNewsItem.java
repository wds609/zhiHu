package com.me.daily.ui.adapter.item;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.me.daily.core.api.ZhiHuApi;
import com.me.daily.core.bean.News;
import com.me.daily.ui.activity.DailyNewsActivity;
import com.me.daily.ui.activity.DetailNewsActivity;
import com.me.daily.ui.adapter.holder.DailyNewsItemViewHolder;
import com.me.daily.utils.Constants;

/**
 * Created by wds on 9/24/2015.
 */
public class DailyNewsItem extends MultipleTypesAdapterItem<News> {

    public DailyNewsItem(int viewType, News data) {
        super(viewType, data);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final Context context) {
        DailyNewsItemViewHolder item = (DailyNewsItemViewHolder) holder;
        Glide.with(context).load(data.imageUrls.get(0)).into(item.image);
        item.title.setText(data.title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DailyNewsActivity.goToDetail(context, ZhiHuApi.ZHIHU_DAILY_NEWS_CONTENT + data.id);
            }
        });
    }

}
