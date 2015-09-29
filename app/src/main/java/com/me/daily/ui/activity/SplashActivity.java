package com.me.daily.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.me.daily.R;
import com.me.daily.core.api.ZhiHuApi;
import com.me.daily.core.bean.Cover;
import com.me.daily.core.task.RefreshArg;
import com.me.daily.core.task.RefreshTask;
import com.me.daily.utils.DateUtil;
import com.me.daily.utils.PrefUtil;
import com.me.daily.utils.TimerUtil;

import butterknife.Bind;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by wds on 9/10/2015.
 */
public class SplashActivity extends BaseActivity {
    @Bind(R.id.img_splash)
    ImageView imageSplash;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new RefreshTask(DateUtil.getToday()).execute(RefreshArg.ALL);
        new TimerUtil(new TimerUtil.CallBack() {
            @Override
            public void onTimerEnd() {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, DailyNewsActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000).start();
    }

    /**
     * This method will be called when a Cover is posted by EventBus
     *
     * @param cover
     */
    @Subscribe(threadMode = ThreadMode.MainThread, sticky = true)
    public void onGetCover(Cover cover) {
        Glide.with(this).load(cover.imageUrl).transform(new CenterCrop(this) {
            @Override
            protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
                Palette.from(toTransform).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette p) {
                        int baseColor=p.getVibrantSwatch().getRgb();
                        PrefUtil.saveBaseColor(getApplicationContext(), baseColor);
                        setStatusBarColor(baseColor);
                    }
                });
                return super.transform(pool, toTransform, outWidth, outHeight);
            }
        }).into(imageSplash);
    }

}
