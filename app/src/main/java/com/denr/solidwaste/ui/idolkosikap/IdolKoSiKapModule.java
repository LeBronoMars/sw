package com.denr.solidwaste.ui.idolkosikap;

import dagger.Module;
import dagger.Provides;

@Module
public class IdolKoSiKapModule {

    @Provides
    IdolKoSiKapViewModel provideIdolKoSiKapViewModel() {
        return new IdolKoSiKapViewModel();
    }
}
