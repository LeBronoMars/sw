package com.denr.solidwaste.api;


import com.denr.solidwaste.utils.rx.errorparser.RxErrorParser;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import retrofit2.Response;

public class FailedRequestTransformer<T>
        implements SingleTransformer<Response<T>, Response<T>> {

    private RxErrorParser rxErrorParser;

    @Inject
    public FailedRequestTransformer(RxErrorParser rxErrorParser) {
        this.rxErrorParser = rxErrorParser;
    }

    @Override
    public SingleSource<Response<T>> apply(Single<Response<T>> upstream) {
        return upstream.flatMap(response -> {
                if (null != response.errorBody()) {
                    return rxErrorParser.parseError(response)
                            .flatMap(apiErrorDto -> {
                                    // retrieve the error message thrown by the API.
                                    return Single.error(new FailedRequestException(apiErrorDto
                                                .getMessage()));
                                });
                }
                return Single.just(response);
            }
        );
    }
}
