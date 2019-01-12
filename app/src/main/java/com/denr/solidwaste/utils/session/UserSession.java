package com.denr.solidwaste.utils.session;

import android.content.SharedPreferences;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface UserSession {

    /**
     * Determine if there's currently stored user session.
     * This means that we have an unexpired stored API Token on our {@link SharedPreferences}.
     */
    Single<Boolean> hasExistingUserSession();

    /**
     * Retrieve the API Token associated with the currently logged in user.
     * */
    Single<String> getToken();

    /**
     * This will remove the current user from SharedPreference whenever the user logs out from the
     * app or the user session has expired.
     * */
    Completable removeCurrentUser();
}
