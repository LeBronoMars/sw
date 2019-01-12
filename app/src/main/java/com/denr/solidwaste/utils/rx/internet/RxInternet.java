package com.denr.solidwaste.utils.rx.internet;

import io.reactivex.Completable;

public interface RxInternet {

    Completable hasInternetConnection();
}
