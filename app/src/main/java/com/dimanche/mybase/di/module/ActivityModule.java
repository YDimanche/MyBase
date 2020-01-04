package com.dimanche.mybase.di.module;

import android.app.Activity;

import com.dimanche.mybase.di.scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 14:07
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
