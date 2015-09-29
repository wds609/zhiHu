package com.me.daily.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.me.daily.R;
import com.me.daily.utils.ColorUtil;
import com.me.daily.utils.PrefUtil;

import butterknife.Bind;

/**
 * Created by wds on 9/11/2015.
 */
public class DailyNewsActivity extends BaseActivity {
    @Bind(R.id.my_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolBar();
        setSupportActionBar(toolbar);
    }

    private void setupToolBar() {
        toolbar.setBackgroundColor(PrefUtil.getBaseColor(this));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_daily_news;
    }

    @Override
    public boolean isUseEventBus() {
        return false;
    }
}
