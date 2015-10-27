package com.me.daily.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.me.daily.R;
import com.me.daily.core.api.ZhiHuApi;
import com.me.daily.core.bean.TopNews;
import com.me.daily.ui.activity.DailyNewsActivity;

import java.util.ArrayList;

/**
 * Created by wds on 9/23/2015.
 */
public class TopNewsAdapter extends PagerAdapter {
    public TopNews topNews;
    private Context mContext;

    public TopNewsAdapter(TopNews topNews, Context context) {
        this.topNews = topNews;
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.top_news_item, null, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DailyNewsActivity.goToDetail(mContext, ZhiHuApi.ZHIHU_DAILY_NEWS_CONTENT + topNews.topNews.get(position).id);
            }
        });
        Glide.with(mContext).load(topNews.topNews.get(position).imageUrl).into((ImageView) view.findViewById(R.id.image));
        ((TextView) view.findViewById(R.id.title)).setText(topNews.topNews.get(position).title);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return topNews == null ? 0 : topNews.topNews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
