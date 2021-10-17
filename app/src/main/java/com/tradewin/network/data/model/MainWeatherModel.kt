package com.tradewin.network.data.model

import com.google.gson.annotations.SerializedName
import com.tradewin.network.data.model.CurrentModel
import com.tradewin.network.data.model.DailyModel

data class MainWeatherModel(

    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("timezone_offset") val timezone_offset: Int,
    @SerializedName("current") val currentModel: CurrentModel,
    @SerializedName("daily") val dailyModel: List<DailyModel>
)