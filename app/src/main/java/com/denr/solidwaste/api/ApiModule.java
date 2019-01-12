package com.denr.solidwaste.api;

import dagger.Binds;
import dagger.Module;

@Module
public interface ApiModule {

    @Binds
    ApiFactory bindApiFactory(ApiFactoryImpl apiFactoryImpl);
}
