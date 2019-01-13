package com.denr.solidwaste.ui.home;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @Provides
    HomeViewModel provideHomeViewModel() {
        return new HomeViewModel();
    }
}
