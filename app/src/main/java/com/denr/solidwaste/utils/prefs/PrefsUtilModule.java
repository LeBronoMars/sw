package com.denr.solidwaste.utils.prefs;

import dagger.Binds;
import dagger.Module;

@Module
public interface PrefsUtilModule {

    @Binds
    PrefsUtil bindPrefsUtil(PrefsUtilImpl prefsUtil);
}
