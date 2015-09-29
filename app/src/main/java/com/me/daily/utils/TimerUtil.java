package com.me.daily.utils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wds on 9/17/2015.
 */
public class TimerUtil {
    public static interface CallBack {
        public void onTimerEnd();
    }

    private Timer mTimer;
    private TimerTask mTask;
    private long mDelay;

    public TimerUtil(final CallBack callBack, long delay) {
        mTimer = new Timer();
        mTask = new TimerTask() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.onTimerEnd();
                }
            }
        };
        mDelay = delay;
    }

    public void start() {
        mTimer.schedule(mTask, mDelay);
    }
}
