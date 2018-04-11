package com.victormotogna.lilac.api;

import android.content.Context;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class LilacApi {
    private Context context;

    private Retrofit retrofit;
    private LilacApiService apiService;

    public static final String BASE_URL = "https://demo9997383.mockable.io/";

    @Inject
    public LilacApi(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public LilacApiService getApiService() {
        if(apiService == null) {
            apiService = retrofit.create(LilacApiService.class);
        }

        return apiService;
    }

    public interface LilacApiService {
        @GET(LilacApi.BASE_URL + "getOrders")
        Call<JsonArray> getOrders();
    }
}
