package com.tradewin.network.data.model

import com.google.gson.annotations.SerializedName


data class FeelsLikeModel (

	@SerializedName("day") val day : Double,
	@SerializedName("night") val night : Double,
	@SerializedName("eve") val eve : Double,
	@SerializedName("morn") val morn : Double
)