package com.me.daily.core.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

/**
 * Created by wds on 9/11/2015.
 */
public class News {
    //for dailynews
    @JSONField(name = "images")
    public ArrayList<String> imageUrls;
    //for topnews
    @JSONField(name = "image")
    public String imageUrl;

    public String title;
    public String id;
}
