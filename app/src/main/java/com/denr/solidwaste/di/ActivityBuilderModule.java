package com.denr.solidwaste.di;

import com.denr.solidwaste.ui.home.HomeActivity;
import com.denr.solidwaste.ui.home.HomeModule;
import com.denr.solidwaste.ui.home.fragment.HomeFragmentProvider;
import com.denr.solidwaste.ui.welcome.WelcomeActivity;
import com.denr.solidwaste.ui.welcome.WelcomeModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {
            HomeModule.class,
            HomeFragmentProvider.class
        })
    HomeActivity bindHomeActivity();

    @ContributesAndroidInjector(modules = {
            WelcomeModule.class,
        })
    WelcomeActivity bindWelcomeActivity();
}
