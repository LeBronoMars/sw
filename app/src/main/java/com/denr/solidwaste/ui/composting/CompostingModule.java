package com.denr.solidwaste.ui.composting;

import dagger.Module;
import dagger.Provides;

@Module
public class CompostingModule {

    @Provides
    CompostingViewModel provide() {
        return new CompostingViewModel();
    }
}
