package com.denr.solidwaste.utils.rx.errorparser;


import com.denr.solidwaste.api.ApiErrorDto;
import com.denr.solidwaste.api.ApiFactory;
import com.denr.solidwaste.api.FailedRequestException;

import java.lang.annotation.Annotation;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;

import static com.denr.solidwaste.base.Constant.GENERIC_ERROR_MESSAGE;


public class RxErrorParserImpl implements RxErrorParser {

    private ApiFactory apiFactory;

    @Inject
    public RxErrorParserImpl(ApiFactory apiFactory) {
        this.apiFactory = apiFactory;
    }

    @Override
    public Single<ApiErrorDto> parseError(Response response) {
        return apiFactory
                .retrofit()
                .flatMap(retrofit -> Single.just(retrofit.responseBodyConverter(ApiErrorDto.class,
                        new Annotation[0])))
                .flatMap(converter -> Single.just((ApiErrorDto)
                        converter.convert(response.errorBody())))
                .onErrorResumeNext(Single.error(new FailedRequestException(GENERIC_ERROR_MESSAGE)));
    }
}
