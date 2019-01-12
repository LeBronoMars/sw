package com.denr.solidwaste.utils.rx;

import com.denr.solidwaste.utils.rx.errorparser.RxErrorParser;
import com.denr.solidwaste.utils.rx.errorparser.RxErrorParserImpl;
import com.denr.solidwaste.utils.rx.internet.RxInternet;
import com.denr.solidwaste.utils.rx.internet.RxInternetImpl;
import com.denr.solidwaste.utils.rx.scheduler.RxScheduler;
import com.denr.solidwaste.utils.rx.scheduler.RxSchedulerImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface RxUtilityModule {

    @Binds
    RxErrorParser bindRxErrorParser(RxErrorParserImpl rxErrorParserImpl);

    @Binds
    RxInternet bindsRxInternet(RxInternetImpl rxInternetImpl);

    @Binds
    RxScheduler bindRxScheudle(RxSchedulerImpl rxSchedulerImpl);
}
