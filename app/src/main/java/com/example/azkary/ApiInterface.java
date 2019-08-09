package com.example.azkary;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("azkar_sabah.json")
    Call<ListOfAzkar> getAzkar();

    @GET("azkar_massa.json")
    Call<ListOfAzkar> getAzkarElMasa2();
}
