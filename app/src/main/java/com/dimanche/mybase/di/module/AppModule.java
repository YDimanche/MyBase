package com.dimanche.mybase.di.module;

import com.dimanche.mybase.app.App;
import com.dimanche.mybase.model.db.DBHelper;
import com.dimanche.mybase.model.db.RealmHelper;
import com.dimanche.mybase.model.http.HttpHelper;
import com.dimanche.mybase.model.http.RetrofitHelper;
import com.dimanche.mybase.model.prefs.ImpPreferencesHelper;
import com.dimanche.mybase.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 13:23
 */
@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Singleton
    @Provides
    App provideApplicationContext() {
        return application;
    }

    @Singleton
    @Provides
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Singleton
    @Provides
    DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }

    @Singleton
    @Provides
    PreferencesHelper providePreferencesHelper(ImpPreferencesHelper impPreferencesHelper) {
        return impPreferencesHelper;
    }

}
