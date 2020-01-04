package com.dimanche.mybase.di.component;

import android.app.Activity;

import com.dimanche.mybase.di.module.ActivityModule;
import com.dimanche.mybase.di.scope.ActivityScope;

import dagger.Component;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 14:13
 */
//@ActivityScope，让该Component和activity的生命周期一致
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();


}
