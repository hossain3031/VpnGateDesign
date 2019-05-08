package com.samsolution.vpngatedesign.network;

import com.samsolution.vpngatedesign.model.ServerInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    /*@GET("/api/?getserverlist&token=")
    Call<List<ServerInfo>> getServerInfo(@Query("token") String token);     //Auto added*/

    @GET("/api/?getserverlist")
    Call<ServerInfo> getAllInfo(@Query("token") String token);
    //Call<List<ServerInfo>> getAllInfo(@Path("token") String token);


}
