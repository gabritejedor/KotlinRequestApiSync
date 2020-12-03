package com.example.kotlinrequestapisync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinrequestapisync.Services.WeatherApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            getApiValue()
        }
    }
    private fun getApiValue()
    {
        var respuesta = ""
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            val response = async(Dispatchers.IO) {
                WeatherApiService.callWeatherApi(applicationContext)
               // WeatherApiService.callWeatherApiAsyng(applicationContext)
            }
            respuesta = response.await()
            println("El valor es " + respuesta)
        }

    }
}
