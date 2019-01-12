package com.denr.solidwaste.di;

import android.arch.persistence.room.Room;

import com.denr.solidwaste.base.AppDatabase;
import com.denr.solidwaste.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    static AppDatabase provideDatabase(BaseApplication baseApplication) {
        return Room.databaseBuilder(baseApplication,
                                    AppDatabase.class, "database.sql")
                   .fallbackToDestructiveMigration()
                   .build();
    }
}
