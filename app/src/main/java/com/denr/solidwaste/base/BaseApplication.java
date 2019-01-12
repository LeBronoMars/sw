package com.denr.solidwaste.base;

import android.app.Activity;
import android.app.Application;

import com.denr.solidwaste.BuildConfig;
import com.denr.solidwaste.di.AppComponent;
import com.denr.solidwaste.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public class BaseApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeComponent().inject(this);

        if (BuildConfig.DEBUG) {
            initializeTimber();
        }
    }

    AppComponent initializeComponent() {
        return DaggerAppComponent
                .builder()
                .application(this)
                .build();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    private void initializeTimber() {
        Timber.plant(new Timber.DebugTree());
    }
}
