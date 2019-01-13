package com.denr.solidwaste.ui.home.fragment;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeFragmentModule {

    @Provides
    HomeFragmentViewModel provideHomeFragmentViewModel() {
        return new HomeFragmentViewModel();
    }
}
