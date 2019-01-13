package com.denr.solidwaste.ui.home;

import com.denr.solidwaste.ui.home.fragment.HomeFragment;
import com.denr.solidwaste.ui.home.fragment.HomeFragmentModule;
import com.denr.solidwaste.ui.home.sites.SitesFragment;
import com.denr.solidwaste.ui.home.sites.SitesFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface HomeFragmentProvider {

    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    HomeFragment provideHomeFragment();

    @ContributesAndroidInjector(modules = SitesFragmentModule.class)
    SitesFragment provideSitesFragment();
}
