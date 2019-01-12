package com.denr.solidwaste.api;

import io.reactivex.Single;
import retrofit2.Retrofit;

public interface ApiFactory {

    /**
     * This will be used for API request that are not requiring an authentication token on header.
     *
     * e.g. Login Request, Forgot Password, etc.
     *
     * */
    <T> Single<T> create(Class<T> apiClass);

    /**
     * This will be used if the API request requires an authentication token on it's header.
     * */
    <T> Single<T> createWithHeader(Class<T> apiClass);

    /**
     * Expose instance of {@link Retrofit} whenever other module is in need of it.
     * */
    Single<Retrofit> retrofit();
}
