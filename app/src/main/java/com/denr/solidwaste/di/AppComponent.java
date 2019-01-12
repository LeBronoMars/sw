package com.denr.solidwaste.di;

import com.denr.solidwaste.api.ApiModule;
import com.denr.solidwaste.base.BaseApplication;
import com.denr.solidwaste.utils.prefs.PrefsUtilModule;
import com.denr.solidwaste.utils.rx.RxUtilityModule;
import com.denr.solidwaste.utils.session.UserSessionModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        ActivityBuilderModule.class,
        AndroidInjectionModule.class,
        ApiModule.class,
        AppModule.class,
        DatabaseModule.class,
        PrefsUtilModule.class,
        RxUtilityModule.class,
        UserSessionModule.class,
    })
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(BaseApplication baseApplication);

        AppComponent build();
    }

    void inject(BaseApplication baseApplication);
}
