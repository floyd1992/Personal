package com.tieguo.personal.sdk.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by wj on 2018/8/14 0014.
 */

public class StatusBarUtil {


    /**
     * 设置状态栏背景色
     * 4.4以下不处理
     * 4.4使用默认沉浸式状态栏
     *
     * @param color 要为状态栏设置的颜色值
     */
    public static void setBarColor(Window win, @ColorInt int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View decorView = win.getDecorView();
            win.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏(4.4-5.0透明，5
            // .0以上半透明)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//android5.0以上设置透明效果
                win.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //清除flag，为了android5.0以上也全透明效果
                //让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | option);
                win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                win.setStatusBarColor(color);//设置状态栏背景色
            }
        }
    }

    /**
     * 设置状态栏全透明
     *
     * @param activity 需要设置的activity
     */
    public static void setTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        setBarColor(activity.getWindow(), Color.TRANSPARENT);
    }

    /**
     * 设置状态栏全透明
     *
     * @param dialog 需要设置的dialog
     */
    public static void setTransparent(Dialog dialog) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        setBarColor(dialog.getWindow(), Color.TRANSPARENT);
    }

    /**
     * 设置状态栏全透明
     *
     * @param window 需要设置的window
     */
    public static void setTransparent(Window window) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        setBarColor(window, Color.TRANSPARENT);
    }


}
