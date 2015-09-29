package com.me.daily.ui.fragment;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.me.daily.R;

import butterknife.Bind;

/**
 * Created by wds on 9/29/2015.
 */
public class DetailNewsFragment extends BaseFragment {
    @Bind(R.id.webView)
    WebView webView;
    public String mUrl;

    public DetailNewsFragment(String mUrl) {
        this.mUrl = mUrl;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_detail_news;
    }

    public boolean isUseEventBus() {
        return false;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupWebView();
        webView.loadUrl(mUrl);
    }

    private void setupWebView() {

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new ChromeClient());
        webView.setWebViewClient(new ViewClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setAppCacheEnabled(true);
    }

    private class ViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url != null) view.loadUrl(url);
            return true;
        }
    }

    private class ChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
    }
}
