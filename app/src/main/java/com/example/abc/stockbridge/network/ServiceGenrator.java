package com.example.abc.stockbridge.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ServiceGenrator  {

    public static String apiURL = "";
    private static Retrofit retrofit;

    private static Retrofit.Builder builder=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create());

    private ServiceGenrator(){}


    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    public static <S> S createService(Class<S> serviceClass,String apiURL){
        retrofit = builder.baseUrl(apiURL).build();
        return retrofit.create(serviceClass);
    }
}
