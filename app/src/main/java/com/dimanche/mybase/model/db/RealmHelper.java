package com.dimanche.mybase.model.db;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/3 23:12
 */
public class RealmHelper implements DBHelper {

    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    @Inject
    public RealmHelper() {
        mRealm=Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }
}
