package com.tradewin.network.data.model

import com.google.gson.annotations.SerializedName

data class MainCoordModel(
    @SerializedName("coord")
    val coordinates: CoordModel
)

data class CoordModel(
    val lat: Float?,
    val lon: Float?
)