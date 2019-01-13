package com.denr.solidwaste.di;

import com.denr.solidwaste.ui.basurakid.BasuraKidActivity;
import com.denr.solidwaste.ui.basurakid.BasuraKidModule;
import com.denr.solidwaste.ui.fantastik4.Fantastik4Activity;
import com.denr.solidwaste.ui.fantastik4.Fantastik4Module;
import com.denr.solidwaste.ui.home.HomeActivity;
import com.denr.solidwaste.ui.home.HomeFragmentProvider;
import com.denr.solidwaste.ui.home.HomeModule;
import com.denr.solidwaste.ui.ra9003.Ra9003Activity;
import com.denr.solidwaste.ui.ra9003.Ra9003Module;
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

    @ContributesAndroidInjector(modules = {
            Ra9003Module.class,
        })
    Ra9003Activity bindRa9003Activity();

    @ContributesAndroidInjector(modules = {
            Fantastik4Module.class,
        })
    Fantastik4Activity bindFantastik4Activity();

    @ContributesAndroidInjector(modules = {
            BasuraKidModule.class,
        })
    BasuraKidActivity bindBasuraKidActivity();
}
