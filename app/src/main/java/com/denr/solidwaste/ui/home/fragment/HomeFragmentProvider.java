package com.denr.solidwaste.ui.home.fragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface HomeFragmentProvider {

    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    HomeFragment provideHomeFragment();
}
