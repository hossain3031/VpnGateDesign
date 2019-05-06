package com.samsolution.vpngatedesign.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {

    //private static final String BASE_URL = "http://ifconfig.co";
    private static final String BASE_URL = "http://manage.v4v.info/";
    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    private RetrofitApiClient() {

    }
    // Empty Constructor - Singleton implementation - It's private

    // পুরো প্রজেক্টে Retrofit  এর মাত্র  একটি instance create  করা  হবে।  আর তা হবে getClient()  মেথডে।
    //To make a network call, we will use RetrofitApiClient() method
    public static Retrofit getClient() {
        if (retrofit == null) {
            synchronized (RetrofitApiClient.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .baseUrl(BASE_URL)
                            .build();
                }
            }
        }
        return retrofit;
    }

}