package com.denr.solidwaste.utils.rx.internet;

import android.support.annotation.VisibleForTesting;

public class NoInternetConnectionException extends Throwable {

    @VisibleForTesting
    public static final String ERROR_MESSAGE = "No internet connection";

    public NoInternetConnectionException() {
        super(ERROR_MESSAGE);
    }
}
