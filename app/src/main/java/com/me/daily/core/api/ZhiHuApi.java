package com.me.daily.core.api;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.me.daily.core.bean.Cover;
import com.me.daily.core.bean.DailyNews;
import com.me.daily.core.bean.TopNews;
import com.me.daily.core.http.SimpleHttpClient;
import com.me.daily.utils.DateUtil;
import com.squareup.okhttp.Response;

import java.util.Calendar;


/**
 * Created by wds on 9/11/2015.
 */
public class ZhiHuApi implements DataSourceInterface {
    private static final String COVER_URL = "http://news-at.zhihu.com/api/4/start-image/1080*1776";
    private static final String TOP_NEWS_URL = "http://news-at.zhihu.com/api/4/news/latest";
    private static final String DAILY_NEWS_URL = "http://news.at.zhihu.com/api/4/news/before/";
    public static final String ZHIHU_DAILY_NEWS_CONTENT = "http://daily.zhihu.com/story/";

    private SimpleHttpClient mHttpClient = new SimpleHttpClient();

    private static ZhiHuApi sZhihuApi;

    private ZhiHuApi() {
    }

    public static ZhiHuApi getInstance() {
        if (sZhihuApi == null) {
            synchronized (ZhiHuApi.class) {
                if (sZhihuApi == null)
                    sZhihuApi = new ZhiHuApi();
            }
        }
        return sZhihuApi;
    }

    @Override
    public Cover getCover() {
        try {
            Response response = mHttpClient.getRequest(COVER_URL);
            return JSON.parseObject(response.body().string(), Cover.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param day formate is yyyyMMdd
     */
    @Override
    public DailyNews getDailyNews(final Calendar day) {
        try {
            day.add(Calendar.DAY_OF_YEAR, 1);
            String formateDay = DateUtil.getFormatedDate(day);
            StringBuffer url = new StringBuffer(DAILY_NEWS_URL);
            url.append(formateDay);
            Response response = mHttpClient.getRequest(url.toString());
            return JSON.parseObject(response.body().string(), DailyNews.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public TopNews getTopNews() {
        try {
            Response response = mHttpClient.getRequest(TOP_NEWS_URL);
            return JSON.parseObject(response.body().string(), TopNews.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
