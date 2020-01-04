package com.dimanche.mybase.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.dimanche.mybase.app.App;

import javax.inject.Inject;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/3 23:25
 */
public class ImpPreferencesHelper implements PreferencesHelper {

    private static final String SHAREDPREFERENCES_NAME = "my_base_sp";

    private final SharedPreferences mSPrefs;

    @Inject
    public ImpPreferencesHelper() {
        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

}
