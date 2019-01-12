package com.denr.solidwaste.utils.prefs;

import android.content.SharedPreferences;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface PrefsUtil {

    /**
     * Clear all currently stored data on {@link SharedPreferences}
     */
    Completable clearAll();

    /**
     * Retrieve a stored String on {@link SharedPreferences} by key.
     *
     * @param key unique identifier to retrieve data from prefs.
     */
    Single<String> getString(String key);

    /**
     * Retrieve a stored boolean on {@link SharedPreferences} by key.
     *
     * @param key unique identifier to retrieve data from prefs.
     */
    Single<Boolean> getBoolean(String key);

    /**
     * Store a given string to {@link SharedPreferences} using the given key.
     *
     * @param key   unique identifier to store the string from prefs, and can be used later for
     *              retrieving.
     * @param value desired string to be saved on prefs.
     */
    Completable putString(String key, String value);

    /**
     * Store a given boolean to {@link SharedPreferences} using the given key.
     *
     * @param key   unique identifier to store the string from prefs, and can be used later for
     *              retrieving.
     * @param value desired string to be saved on prefs.
     */
    Completable putBoolean(String key, boolean value);

    /**
     * Convert any given object to string and save it to prefs.
     *
     * @param key    unique identifier to store the string from prefs, and can be used later for
     *               retrieving.
     * @param object {@link Object} to be converted to string.
     */
    Completable convertObjectToJsonStringAndSave(String key, Object object);

    /**
     * Retrieve data on stored prefs by key and convert it back to object.
     *
     * @param key unique identifier to store the string from prefs, and can be used later for
     *            retrieving.
     * @param <T> the type of class to be returned after the conversion.
     *
     * @return a {@link Single} that emits the converted object coming from the JSON string.
     */
    <T> Single<T> convertJsonStringToObject(String key, Class<T> clazz);
}
