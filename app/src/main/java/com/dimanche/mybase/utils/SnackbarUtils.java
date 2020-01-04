package com.dimanche.mybase.utils;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 21:52
 */
public class SnackbarUtils {

    public static void show(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

}
