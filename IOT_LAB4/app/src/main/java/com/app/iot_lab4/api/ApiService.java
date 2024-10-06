package com.app.iot_lab4.api;

import com.app.iot_lab4.model.Liga;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/v1/json/3/all_leagues.php")
    Call<ResponseLigas> getAllLeagues();

    @GET("api/v1/json/3/search_all_leagues.php")
    Call<ResponseLigasPorPais> getLeaguesByCountry(@Query("c") String country);

    @GET("api/v1/json/3/lookuptable.php")
    Call<ResponsePosicionEquipos> getPosicionesByLiga(@Query("l") String idLiga, @Query("s") String temporada);

    @GET("api/v1/json/3/eventsround.php")
    Call<ResponseResultados> getResultadosByLigaTemporadaRonda(@Query("id") String idLiga,
                                                               @Query("r") String ronda,
                                                               @Query("s") String temporada);

}
