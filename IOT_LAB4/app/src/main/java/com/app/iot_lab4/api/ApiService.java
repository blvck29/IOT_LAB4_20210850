package com.app.iot_lab4.api;

import com.app.iot_lab4.model.Liga;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/v1/json/3/all_leagues.php")
    Call<ResponseLigas> getAllLeagues();
}
