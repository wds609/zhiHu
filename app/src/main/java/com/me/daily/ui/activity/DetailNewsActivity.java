package com.me.daily.ui.activity;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.me.daily.R;
import com.me.daily.ui.fragment.DetailNewsFragment;
import com.me.daily.utils.Constants;
import com.me.daily.utils.PrefUtil;

import butterknife.Bind;

/**
 * Created by wds on 9/29/2015.
 */
public class DetailNewsActivity extends BaseActivity {
    @Bind(R.id.my_toolbar)
    Toolbar toolbar;
    private OnBackKeyPressedListener mBackListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolBar();
        setSupportActionBar(toolbar);
        String extraUrl = getIntent().getStringExtra(Constants.EXTRA_URL);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        DetailNewsFragment fragment = new DetailNewsFragment(extraUrl);
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    private void setupToolBar() {
        toolbar.setBackgroundColor(PrefUtil.getBaseColor(this));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail_news;
    }

    @Override
    public boolean isUseEventBus() {
        return false;
    }

    @Override
    public void onBackPressed() {
        if (mBackListener != null) {
            mBackListener.onBackPressed();
        }

    }

    public void setBackListener(OnBackKeyPressedListener listener) {
        mBackListener = listener;
    }

    public interface OnBackKeyPressedListener {
        public void onBackPressed();
    }
}
