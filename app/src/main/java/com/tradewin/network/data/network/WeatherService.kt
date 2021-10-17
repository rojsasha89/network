package com.tradewin.network.data.network

import com.tradewin.network.data.model.MainCoordModel
import com.tradewin.network.data.model.MainWeatherModel
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/onecall")
    fun getCurrentWeather(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?,
        @Query("exclude") exclude: String,
        @Query("appid") appId: String,
        @Query("units") units: String,
        @Query("lang") lang: String
    ): Call<MainWeatherModel>

    @GET("data/2.5/weather")
    fun getCurrentCoordinates(
        @Query("appid") appId: String,
        @Query("q") city: String
    ): Call<MainCoordModel>
}