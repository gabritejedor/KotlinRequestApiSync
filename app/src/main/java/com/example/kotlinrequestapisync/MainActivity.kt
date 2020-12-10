package com.example.kotlinrequestapisync


import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
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
        val toolbar : Toolbar = findViewById<Toolbar>(R.id.toolbar_main)


        setSupportActionBar(toolbar)
        button.setOnClickListener {
            getApiValue()
        }

    }
    override fun onCreateOptionsMenu(menu : Menu) : Boolean{
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbarmenu, menu);
        return true

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
