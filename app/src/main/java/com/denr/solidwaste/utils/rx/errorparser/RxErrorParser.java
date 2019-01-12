package com.denr.solidwaste.utils.rx.errorparser;


import com.denr.solidwaste.api.ApiErrorDto;

import io.reactivex.Single;
import retrofit2.Response;

public interface RxErrorParser {

    Single<ApiErrorDto> parseError(Response response);
}
