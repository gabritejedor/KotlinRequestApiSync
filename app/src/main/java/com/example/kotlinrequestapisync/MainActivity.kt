package com.example.kotlinrequestapisync


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinrequestapisync.Models.Adaptador
import com.example.kotlinrequestapisync.Models.Provincia

import com.example.kotlinrequestapisync.Services.WeatherApiService.Companion.callWeatherApiAsyng
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private var mLayoutManager: RecyclerView.LayoutManager? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar : Toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        button.setOnClickListener {
                getApiValue()
        }
        recyclerView.setHasFixedSize(true)
        mLayoutManager =  LinearLayoutManager(this)
        recyclerView.layoutManager =mLayoutManager

      /*  var prueba : List<Provincia> = listOf(Provincia("1","Alava"),Provincia("2","Andalucia"))
        val mAdapter = Adaptador(prueba,this)
        recyclerView.adapter = mAdapter*/



    }
    override fun onCreateOptionsMenu(menu: Menu) : Boolean{
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbarmenu, menu);
        return true

    }
  private fun getApiValue()
    {
        var respuesta = ""
        var respuesta2 = ""
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
          /*  val response = async(Dispatchers.IO) {
                WeatherApiService.callWeatherApi(applicationContext)
               // WeatherApiService.callWeatherApiAsyng(applicationContext)
            }*/
          callWeatherApiAsyng(applicationContext,recyclerView)
           /* respuesta = response.await()

            println("El valor es " + respuesta)*/

        }

    }


}
