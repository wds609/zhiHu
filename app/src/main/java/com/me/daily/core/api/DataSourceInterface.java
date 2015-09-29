package com.me.daily.core.api;

import android.support.annotation.WorkerThread;

import com.me.daily.core.bean.Cover;
import com.me.daily.core.bean.DailyNews;
import com.me.daily.core.bean.TopNews;

import java.util.Calendar;

/**
 * Created by wds on 9/11/2015.
 */
public interface DataSourceInterface {


    @WorkerThread
    public Cover getCover();

    @WorkerThread
    public DailyNews getDailyNews(Calendar day);

    @WorkerThread
    public TopNews getTopNews();


}
