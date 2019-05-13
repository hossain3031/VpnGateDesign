package com.samsolution.vpngatedesign.network;

import com.samsolution.vpngatedesign.model.Post;
import com.samsolution.vpngatedesign.model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "http://manage.v4v.info/";

    @GET("api/")
    Call<ServerResponse> getServerResult(@Query(value = "token", encoded=true) String token);

    @POST("api/vpnprofile")
    @FormUrlEncoded
    Call<Post> getRequest (
            @Field("id") int id,
            @Field("token") String token);

}
