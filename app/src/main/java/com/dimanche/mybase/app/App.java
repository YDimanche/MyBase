package com.dimanche.mybase.app;

import android.app.Activity;
import android.app.Application;

import com.dimanche.mybase.di.component.AppComponent;
import com.dimanche.mybase.di.component.DaggerAppComponent;
import com.dimanche.mybase.di.module.AppModule;
import com.dimanche.mybase.di.module.HttpModule;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dimanche
 * @description:
 * @date : 2019/12/30 23:59
 */
public class App extends Application {
    private static App instance;
    private Set<Activity> activities;
    private static AppComponent mAppComponent;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public void addActivity(Activity activity) {
        if (activities == null) {
            activities = new HashSet<>();
        }
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (activities != null) {
            activities.remove(activity);
        }
    }

    public void exitApp() {
        if (activities != null) {
            synchronized (activities) {
                for (Activity activity : activities) {
                    activity.finish();
                }
            }
        }
    }

    public static AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return mAppComponent;
    }
}
