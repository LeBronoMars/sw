package com.denr.solidwaste.api;

import com.denr.solidwaste.BuildConfig;
import com.denr.solidwaste.utils.session.UserSession;

import javax.inject.Inject;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiFactoryImpl implements ApiFactory {

    private UserSession userSession;

    @Inject
    ApiFactoryImpl(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public <T> Single<T> create(Class<T> apiClass) {
        return retrofit()
                .map(retrofit -> retrofit.create(apiClass));
    }

    @Override
    public <T> Single<T> createWithHeader(Class<T> apiClass) {
        return retrofitWithHeader()
                .map(retrofit -> retrofit.create(apiClass));
    }

    private Single<OkHttpClient> client() {
        return Single
                .fromCallable(OkHttpClient.Builder::new)
                .flatMap(this::addLoggingInterceptor)
                .map(OkHttpClient.Builder::build);
    }

    private Single<OkHttpClient> clientWithHeader() {
        return Single
                .fromCallable(OkHttpClient.Builder::new)
                .flatMap(this::addLoggingInterceptor)
                .flatMap(this::addInterceptorForAuthorizationHeader)
                .map(OkHttpClient.Builder::build);
    }

    private Single<Retrofit> intoRetrofit(OkHttpClient client) {
        return Single.fromCallable(
                () -> new Retrofit.Builder()
                        .baseUrl(BuildConfig.BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
        );
    }

    private Single<OkHttpClient.Builder> addLoggingInterceptor(OkHttpClient.Builder builder) {
        return Single.fromCallable(
                () -> {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                builder.addInterceptor(loggingInterceptor);

                return builder;
            });
    }

    /**
     * Intercept an outgoing API request and inject Bearer {{token}} to it's
     * authorization header.
     * */
    private Single<OkHttpClient.Builder> addInterceptorForAuthorizationHeader(
            OkHttpClient.Builder builder) {

        return userSession.getToken()
                .map(token -> {
                        builder.addInterceptor(chain -> {
                                Request original = chain.request();
                                Request request =
                                        original.newBuilder()
                                                .header("Authorization",
                                                        "Bearer " + token)
                                                .build();
                                return chain.proceed(request);
                            }
                        );
                        return builder;
                    });
    }

    @Override
    public Single<Retrofit> retrofit() {
        return client().flatMap(this::intoRetrofit);
    }

    private Single<Retrofit> retrofitWithHeader() {
        return clientWithHeader().flatMap(this::intoRetrofit);
    }
}
