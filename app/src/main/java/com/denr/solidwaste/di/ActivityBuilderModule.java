package com.denr.solidwaste.di;

import com.denr.solidwaste.ui.home.HomeActivity;
import com.denr.solidwaste.ui.home.HomeModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilderModule {


    @ContributesAndroidInjector(modules = {
            HomeModule.class
        })
    HomeActivity bindHomeActivity();
}
