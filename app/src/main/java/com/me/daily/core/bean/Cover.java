package com.me.daily.core.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by wds on 9/11/2015.
 */
public class Cover {
    @JSONField(name = "text")
    public String copyRight;
    @JSONField(name = "img")
    public String imageUrl;

}
