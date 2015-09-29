package com.me.daily.core.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

/**
 * Created by wds on 9/11/2015.
 */
public class TopNews {
    @JSONField(name = "top_stories")
    public ArrayList<News> topNews;
}
