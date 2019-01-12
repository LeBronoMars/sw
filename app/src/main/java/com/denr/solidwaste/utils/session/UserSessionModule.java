package com.denr.solidwaste.utils.session;

import dagger.Binds;
import dagger.Module;

@Module
public interface UserSessionModule {

    @Binds
    UserSession bindsUserSession(UserSessionImpl userSessionImpl);
}
