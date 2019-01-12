package com.denr.solidwaste.di;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import com.denr.solidwaste.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Application provideApplication(BaseApplication baseApplication) {
        return baseApplication;
    }

    @Provides
    @Singleton
    Context provideContext(BaseApplication baseApplication) {
        return baseApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    ConnectivityManager provideConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
