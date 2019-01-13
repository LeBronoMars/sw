package com.denr.solidwaste.ui.ra9003;

import dagger.Module;
import dagger.Provides;

@Module
public class Ra9003Module {

    @Provides
    Ra9003ViewModel provideRa9003ViewModel() {
        return new Ra9003ViewModel();
    }
}
