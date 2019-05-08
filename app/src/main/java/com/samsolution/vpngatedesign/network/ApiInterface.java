package com.samsolution.vpngatedesign.network;

import com.samsolution.vpngatedesign.model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "http://manage.v4v.info/";

    @GET("api/")
    Call<ServerResponse> getServerResult(@Query(value = "token", encoded=true) String token);

}
