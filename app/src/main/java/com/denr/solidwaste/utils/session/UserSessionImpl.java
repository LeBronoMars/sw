package com.denr.solidwaste.utils.session;


import com.denr.solidwaste.utils.prefs.PrefsKey;
import com.denr.solidwaste.utils.prefs.PrefsUtil;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class UserSessionImpl implements UserSession {

    private PrefsUtil prefsUtil;

    @Inject
    public UserSessionImpl(PrefsUtil prefsUtil) {
        this.prefsUtil = prefsUtil;
    }

    @Override
    public Single<Boolean> hasExistingUserSession() {
        return prefsUtil
                .getString(PrefsKey.TOKEN)
                .flatMap(token -> Single.just(true))
                .onErrorReturnItem(false);
    }

    @Override
    public Single<String> getToken() {
        return prefsUtil.getString(PrefsKey.TOKEN);
    }

    @Override
    public Completable removeCurrentUser() {
        return prefsUtil.clearAll();
    }
}
