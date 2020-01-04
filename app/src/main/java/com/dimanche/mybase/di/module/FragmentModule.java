package com.dimanche.mybase.di.module;

import android.app.Activity;

import androidx.fragment.app.Fragment;

import com.dimanche.mybase.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 22:22
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @FragmentScope
    @Provides
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
