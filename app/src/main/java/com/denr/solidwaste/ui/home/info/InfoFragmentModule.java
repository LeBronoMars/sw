package com.denr.solidwaste.ui.home.info;

import dagger.Module;
import dagger.Provides;

@Module
public class InfoFragmentModule {

    @Provides
    InfoFragmentViewModel provideInfoFragmentViewModel() {
        return new InfoFragmentViewModel();
    }
}
