package com.denr.solidwaste.api.auth;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticationApi {

    @POST("/api/user/auth")
    Single<Response<AuthenticationResponseDto>> authenticateUser(
            @Body AuthenticationRequestDto authenticationRequestDto);
}
