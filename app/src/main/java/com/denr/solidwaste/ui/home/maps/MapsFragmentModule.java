package com.denr.solidwaste.ui.home.maps;

import dagger.Module;
import dagger.Provides;

@Module
public class MapsFragmentModule {

    @Provides
    MapsFragmentViewModel provide() {
        return new MapsFragmentViewModel();
    }
}
