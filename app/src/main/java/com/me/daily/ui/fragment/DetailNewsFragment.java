package com.me.daily.ui.fragment;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.me.daily.R;
import com.me.daily.ui.activity.DetailNewsActivity;

import butterknife.Bind;

/**
 * Created by wds on 9/29/2015.
 */
public class DetailNewsFragment extends BaseFragment implements DetailNewsActivity.OnBackKeyPressedListener {
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
        ((DetailNewsActivity) getActivity()).setBackListener(this);
        setupWebView();
        webView.loadUrl(mUrl);
    }

    private void setupWebView() {

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new ChromeClient());
        webView.setWebViewClient(new ViewClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

    private void removeTheHtmlHeader(WebView view) {
        view.loadUrl("javascript:(function(){" +
                "document.getElementsByClassName(\"header-for-mobile\")[0].style.display=\"none\";" +
                "})()");
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            getActivity().finish();
        }
    }

    private class ViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url != null) view.loadUrl(url);
            return true;
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            removeTheHtmlHeader(view);
        }

    }

    private class ChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
    }

}
