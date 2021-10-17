package com.tradewin.network.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCreator {

    private var retrofit: WeatherService? = null

    fun getRetrofit(): WeatherService? {
        if (retrofit == null) retrofit = buildRetrofit()
        return retrofit
    }

    private fun buildRetrofit(): WeatherService {
        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }
}


