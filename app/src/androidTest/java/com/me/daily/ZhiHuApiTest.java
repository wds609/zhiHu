package com.me.daily;

import android.test.AndroidTestCase;

import com.alibaba.fastjson.JSON;
import com.me.daily.core.api.ZhiHuApi;
import com.me.daily.core.bean.Cover;
import com.me.daily.core.bean.DailyNews;

/**
 * Created by wds on 9/11/2015.
 */
public class ZhiHuApiTest extends AndroidTestCase {

    public void testStartImage() {
        Cover cover = JSON.parseObject("{\n" +
                "    text: \"© Fido Dido\",\n" +
                "    img: \"http://p2.zhimg.com/10/7b/107bb4894b46d75a892da6fa80ef504a.jpg\"\n" +
                "}", Cover.class);
        assertNotNull(cover);
        assertEquals("http://p2.zhimg.com/10/7b/107bb4894b46d75a892da6fa80ef504a.jpg", cover.imageUrl);
    }

    public void testGetCover() {
        Cover cover = ZhiHuApi.getInstance().getCover();
        assertNotNull(cover);
    }
    public void testGetDailyNews() {
//        DailyNews news = ZhiHuApi.getInstance().getDailyNews("20150912");
//        assertNotNull(news);
    }
}
