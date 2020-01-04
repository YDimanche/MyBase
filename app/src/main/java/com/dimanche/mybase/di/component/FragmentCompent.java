package com.dimanche.mybase.di.component;

import android.app.Activity;

import com.dimanche.mybase.di.module.FragmentModule;
import com.dimanche.mybase.di.scope.FragmentScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 22:27
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentCompent {
    Activity getActivity();
}
