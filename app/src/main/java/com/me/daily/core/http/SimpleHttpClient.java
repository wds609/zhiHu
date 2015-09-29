package com.me.daily.core.http;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by wds on 9/11/2015.
 */
public class SimpleHttpClient extends OkHttpClient {

    public Response getRequest(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response;
    }
}
