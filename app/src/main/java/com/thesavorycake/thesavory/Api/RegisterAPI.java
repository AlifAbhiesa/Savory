package com.thesavorycake.thesavory.Api;

import com.thesavorycake.thesavory.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by UnixMan on 15/12/2018.
 */

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("Register/registerUser")
    Call<Value> daftar(@Field("nik") String nik,
                       @Field("nama") String nama,
                       @Field("alamat") String alamat,
                       @Field("email") String email,
                       @Field("nohp") String nohp,
                       @Field("password") String password);
}
