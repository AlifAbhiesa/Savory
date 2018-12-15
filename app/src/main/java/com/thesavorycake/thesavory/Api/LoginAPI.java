package com.thesavorycake.thesavory.Api;

import com.thesavorycake.thesavory.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by UnixMan on 15/12/2018.
 */

public interface LoginAPI {
    @FormUrlEncoded
    @POST("Login/loginUser")
    Call<Value> login(@Field("email") String email,
                       @Field("password") String password);
}
