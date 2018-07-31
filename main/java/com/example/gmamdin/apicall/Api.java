package com.example.gmamdin.apicall;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface Api {

    String baseUrl="http://www.mocky.io";

    @GET("v2/5a8e5b372f000048004f25fc")
    Call<List<Places>> getPlaces();
}
