package com.denr.solidwaste.ui.home.sites;

import dagger.Module;
import dagger.Provides;

@Module
public class SitesFragmentModule {

    @Provides
    SitesFragmentViewModel provideSitesFragmentViewModel() {
        return new SitesFragmentViewModel();
    }
}
