package com.denr.solidwaste.utils.rx.internet;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

import io.reactivex.Completable;

import static android.net.NetworkInfo.State.CONNECTED;
import static android.net.NetworkInfo.State.CONNECTING;

public class RxInternetImpl implements RxInternet {

    private ConnectivityManager connectivityManager;

    @Inject
    RxInternetImpl(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    @Override
    public Completable hasInternetConnection() {
        return Completable.fromCallable(() -> {
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                boolean hasConnection =
                        null != networkInfo
                                && (networkInfo.getState() == CONNECTED
                                || networkInfo.getState() == CONNECTING);

                if (hasConnection) return Completable.complete();

                return Completable.error(new NoInternetConnectionException());
            });
    }
}
