package com.me.daily.core.task;

import android.os.AsyncTask;
import android.util.Log;

import com.me.daily.core.api.DataSourceInterface;
import com.me.daily.core.api.ZhiHuApi;
import com.me.daily.core.bean.Cover;
import com.me.daily.core.bean.DailyNews;
import com.me.daily.core.bean.TopNews;

import java.util.Calendar;

import de.greenrobot.event.EventBus;

/**
 * Created by wds on 9/11/2015.
 */
public class RefreshTask extends AsyncTask<RefreshArg, Void, Void> {
    private DataSourceInterface mApi = ZhiHuApi.getInstance();

    private Calendar mDate;

    public RefreshTask(Calendar mDate) {
        this.mDate = mDate;
    }

    @Override
    protected Void doInBackground(RefreshArg... refreshArgs) {
        RefreshArg arg = RefreshArg.ALL;
        if (refreshArgs != null) {
            arg = refreshArgs[0];
        }
        if (arg == RefreshArg.ALL) {
            postCover();
            postTopNews();
            postDailyNews(mDate);
        } else if (arg == RefreshArg.COVER) {
            postCover();
        } else if (arg == RefreshArg.TOPNEWS) {
            postTopNews();
        } else if (arg == RefreshArg.DAILYNEWS) {
            postDailyNews(mDate);
        }
        return null;
    }

    public void postCover() {
        Cover cover = mApi.getCover();
        if (cover != null) {
            EventBus.getDefault().postSticky(cover);
        }
    }

    public void postTopNews() {
        TopNews topNews = mApi.getTopNews();
        if (topNews != null) {
            EventBus.getDefault().postSticky(topNews);
        }
    }

    public void postDailyNews(Calendar date) {
        DailyNews dailyNews = mApi.getDailyNews(date);
        if (dailyNews != null) {
            EventBus.getDefault().postSticky(dailyNews);
        }
    }
}
