package com.me.daily.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.me.daily.R;
import com.me.daily.core.bean.DailyNews;
import com.me.daily.core.bean.News;
import com.me.daily.core.bean.TopNews;
import com.me.daily.core.task.RefreshArg;
import com.me.daily.core.task.RefreshTask;
import com.me.daily.ui.adapter.MultipleTypesAdapter;
import com.me.daily.ui.adapter.holder.ItemViewType;
import com.me.daily.ui.adapter.item.DailyNewsHeaderItem;
import com.me.daily.ui.adapter.item.DailyNewsItem;
import com.me.daily.ui.adapter.item.TopNewsItem;
import com.me.daily.utils.DateUtil;

import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by wds on 9/22/2015.
 */
public class DailyNewsFragment extends BaseFragment {
    @Bind(R.id.list)
    public RecyclerView list;
    @Bind(R.id.refresh)
    public SwipeRefreshLayout refresh;
    private MultipleTypesAdapter mAdapter;
    private Calendar mLastUpdateCalendar;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_daily_news;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        list.setLayoutManager(layoutManager);
        mAdapter = new MultipleTypesAdapter(getActivity());
        list.setAdapter(mAdapter);
        //for down pull refresh
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.getDataList().clear();
                new RefreshTask(DateUtil.getToday()).execute(RefreshArg.ALL);
            }
        });
        //for up pull refresh
        list.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (layoutManager.findLastVisibleItemPosition() >= mAdapter.getItemCount() / 2) {
                    mLastUpdateCalendar.add(Calendar.DAY_OF_YEAR, -1);
                    new RefreshTask(mLastUpdateCalendar).execute(RefreshArg.DAILYNEWS);
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    @Subscribe(threadMode = ThreadMode.MainThread, sticky = true)
    public void onGetDailyNews(DailyNews dailyNews) {
        mLastUpdateCalendar = Calendar.getInstance();
        mLastUpdateCalendar.setTime(dailyNews.date);
        List list = mAdapter.getDataList();
        list.add(new DailyNewsHeaderItem(ItemViewType.TYPE_ITEM_HEADER, dailyNews.date));
        for (News news : dailyNews.dailyNews) {
            list.add(new DailyNewsItem(ItemViewType.TYPE_ITEM, news));
        }
        mAdapter.notifyDataSetChanged();
        refresh.setRefreshing(false);
    }

    @Subscribe(threadMode = ThreadMode.MainThread, sticky = true)
    public void onGetTopNews(TopNews news) {
        //topnew need to add the first postion
        mAdapter.getDataList().add(0, new TopNewsItem(ItemViewType.TYPE_TOP_NEWS, news));
        mAdapter.notifyDataSetChanged();
    }

}
