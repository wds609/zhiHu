package com.me.daily.utils;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by wds on 9/24/2015.
 */
public class PrefUtil {

    private static final String COLOR_BASE = "color_base";

    public static void saveBaseColor(Context context, int color) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(COLOR_BASE, color).commit();
    }

    public static int getBaseColor(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(COLOR_BASE, 0);
    }
}
