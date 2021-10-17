package com.tradewin.network.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tradewin.network.BuildConfig
import com.tradewin.network.R
import com.tradewin.network.data.model.CoordModel
import com.tradewin.network.data.model.MainCoordModel
import com.tradewin.network.data.model.MainWeatherModel
import com.tradewin.network.data.network.RetrofitCreator
import com.tradewin.network.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()

    }

    private fun setupListeners() {
        binding.btnSearchWeather.setOnClickListener {
            getCurrentWeather()
        }
    }

    private fun getCurrentWeather() {
        val city = binding.etCity.text.toString().trim()

        RetrofitCreator.getRetrofit()?.getCurrentCoordinates(
            city = city, appId = BuildConfig.weatherKey
        )?.enqueue(object : Callback<MainCoordModel> {

            override fun onResponse(
                call: Call<MainCoordModel>,
                response: Response<MainCoordModel>
            ) {
                if (response.isSuccessful) {
                    getWeather(response.body()?.coordinates)
                }
            }

            override fun onFailure(call: Call<MainCoordModel>, t: Throwable) {
            }
        })
    }

    private fun getWeather(coordinates: CoordModel?) {
        RetrofitCreator.getRetrofit()?.getCurrentWeather(
            lat = coordinates?.lat.toString(),
            lon = coordinates?.lon.toString(),
            exclude = "minutely,hourly,alerts",
            appId = BuildConfig.weatherKey,
            units = "metric",
            lang = "ru"

        )?.enqueue(object : Callback<MainWeatherModel> {
            override fun onResponse(
                call: Call<MainWeatherModel>,
                response: Response<MainWeatherModel>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    binding.tvCity.text = String.format(
                        resources.getString(R.string.temperature),
                        data?.currentModel?.temp?.toInt().toString()
                    )
                }
            }

            override fun onFailure(call: Call<MainWeatherModel>, t: Throwable) {
                Toast.makeText(applicationContext, "NOOOOO", Toast.LENGTH_SHORT).show()
            }

        })
    }
}