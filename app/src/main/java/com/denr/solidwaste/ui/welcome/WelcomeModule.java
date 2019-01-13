package com.denr.solidwaste.ui.welcome;

import dagger.Module;
import dagger.Provides;

@Module
public class WelcomeModule {

    @Provides
    WelcomeViewModel provideWelcomeViewModel() {
        return new WelcomeViewModel();
    }
}
