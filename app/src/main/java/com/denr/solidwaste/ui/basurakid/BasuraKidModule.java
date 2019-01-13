package com.denr.solidwaste.ui.basurakid;

import dagger.Module;
import dagger.Provides;

@Module
public class BasuraKidModule {

    @Provides
    BasuraKidViewModel provideBasuraKidViewModel() {
        return new BasuraKidViewModel();
    }
}
