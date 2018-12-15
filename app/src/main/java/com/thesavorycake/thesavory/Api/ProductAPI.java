package com.thesavorycake.thesavory.Api;

import com.thesavorycake.thesavory.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by UnixMan on 15/12/2018.
 */

public interface ProductAPI {

    @GET("/Products")
    Call<List<Product>> getProduct();
}
