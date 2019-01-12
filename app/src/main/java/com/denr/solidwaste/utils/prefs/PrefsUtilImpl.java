package com.denr.solidwaste.utils.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.VisibleForTesting;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import timber.log.Timber;

public class PrefsUtilImpl implements PrefsUtil {

    @VisibleForTesting
    public static final String NO_DATA_FOUND = "No stored data found with key ";

    private static final String IM_PREFS = "IM_PREFS";

    private static final String DEFAULT_STRING_VALUE = null;

    private SharedPreferences sharedPreferences;

    @Inject
    public PrefsUtilImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(IM_PREFS, Context.MODE_PRIVATE);
    }

    @Override
    public Completable clearAll() {
        return Completable.defer(() -> {
                sharedPreferences.edit().clear().apply();
                return Completable.complete();
            });
    }

    @Override
    public Single<String> getString(String key) {
        return Single.defer(() -> {
                String value = sharedPreferences.getString(key, DEFAULT_STRING_VALUE);
                if (null == value) {
                    String errorMessage = NO_DATA_FOUND + key;
                    Timber.w(errorMessage);
                    return Single.error(new Throwable(errorMessage));
                }
                return Single.just(value);
            }
        );
    }

    @Override
    public Completable putString(String key, String value) {
        return Completable.fromCallable(() -> {
                sharedPreferences.edit().putString(key, value).apply();
                return Completable.complete();
            });
    }

    @Override
    public Single<Boolean> getBoolean(String key) {
        return Single.fromCallable(() -> sharedPreferences.getBoolean(key, false));
    }

    @Override
    public Completable putBoolean(String key, boolean value) {
        return Completable.fromCallable(() -> {
                sharedPreferences.edit().putBoolean(key, value).apply();
                return Completable.complete();
            });
    }

    @Override
    public Completable convertObjectToJsonStringAndSave(String key, Object object) {
        return Completable.defer(() -> {
                Gson gson = new Gson();
                String data = gson.toJson(object);

                return putString(key, data);
            });
    }

    @Override
    public <T> Single<T> convertJsonStringToObject(String key, Class<T> clazz) {
        return getString(key)
                .flatMap(jsonData -> {
                        Gson gson = new Gson();
                        return Single.just(gson.fromJson(jsonData, clazz));
                    });
    }
}
