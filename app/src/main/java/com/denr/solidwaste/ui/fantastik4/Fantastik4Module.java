package com.denr.solidwaste.ui.fantastik4;

import dagger.Module;
import dagger.Provides;

@Module
public class Fantastik4Module {

    @Provides
    Fantastik4ViewModel provideFantastik4ViewModel() {
        return new Fantastik4ViewModel();
    }
}
