package com.samsolution.vpngatedesign.network;

import com.samsolution.vpngatedesign.model.ServerResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/?getserverlist")
    Call<ServerResponse> getIp(@Query("token") String token);

}
