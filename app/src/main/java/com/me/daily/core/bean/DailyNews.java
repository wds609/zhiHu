package com.me.daily.core.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wds on 9/11/2015.
 */
public class DailyNews {
    public Date date;
    @JSONField(name = "stories")
    public ArrayList<News> dailyNews;

}
