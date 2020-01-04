package com.dimanche.mybase.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.dimanche.mybase.app.App;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 0:53
 */
public class SystemUtils {

    /**
     * 判断当前是否有可用网络
     * @return
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance()
                .getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetwork() != null;
    }


}
