package com.example.azkary;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofitVar =null;
    private static Retrofit azarElMasaa =null;

    public static Retrofit getClient()
    {
        if (retrofitVar== null)
        {
            retrofitVar= new Retrofit.Builder()
                    .baseUrl("https://ahegazy.github.io/muslimKit/json/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitVar;
    }

    public static  Retrofit getAzkarElMasaa()
    {
        if(azarElMasaa== null)
        {
            azarElMasaa= new Retrofit.Builder()
                    .baseUrl("https://ahegazy.github.io/muslimKit/json/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return  azarElMasaa;

    }
}
