package com.dimanche.mybase.di.component;

import com.dimanche.mybase.app.App;
import com.dimanche.mybase.di.module.AppModule;
import com.dimanche.mybase.di.module.HttpModule;
import com.dimanche.mybase.model.db.RealmHelper;
import com.dimanche.mybase.model.http.RetrofitHelper;
import com.dimanche.mybase.model.prefs.ImpPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 13:33
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    App getContext();

    RetrofitHelper retrofitHelper();

    RealmHelper realmHelper();

    ImpPreferencesHelper impPreferencesHelper();
}
