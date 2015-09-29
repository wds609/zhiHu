package com.me.daily.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.me.daily.utils.ColorUtil;
import com.me.daily.utils.PrefUtil;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * Created by wds on 9/10/2015.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        if (layoutId == 0) {
            throw new RuntimeException("Need to pass a layout to activity!!");
        }
        setContentView(layoutId);
        ButterKnife.bind(this);
        if (isUseEventBus())
            EventBus.getDefault().register(this);
        int baseColor = PrefUtil.getBaseColor(this);
        setStatusBarColor(ColorUtil.colorBurn(baseColor));
//        setNavigationBarColor(ColorUtil.colorBurn(baseColor));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isUseEventBus())
            EventBus.getDefault().unregister(this);
    }

    @LayoutRes
    public abstract int getLayoutId();

    public boolean isUseEventBus() {
        return true;
    }

    public static boolean isLmpOrAbove() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    public void setStatusBarColor(int color) {
        if (isLmpOrAbove()) {
            getWindow().setStatusBarColor(color);
        }
    }

    public void setNavigationBarColor(int color) {
        if (isLmpOrAbove()) {
            getWindow().setNavigationBarColor(color);
        }
    }

}
