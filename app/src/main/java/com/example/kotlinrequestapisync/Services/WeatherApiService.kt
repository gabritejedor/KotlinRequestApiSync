package com.example.kotlinrequestapisync.Services

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.Volley
import com.example.kotlinrequestapisync.MainActivity2
import com.example.kotlinrequestapisync.Models.Adaptador
import com.example.kotlinrequestapisync.Models.Provincia
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.util.concurrent.TimeUnit

class WeatherApiService{
    companion object {

        public fun callWeatherApi(con :Context) : String
        {  val queue = Volley.newRequestQueue(con)
           val future = RequestFuture.newFuture<JSONObject>()
           val request =  JsonObjectRequest(Request.Method.GET, "https://www.el-tiempo.net/api/json/v2/home", JSONObject(), future, future)


            try {
                queue.add(request);
                val  response = future.get(30,TimeUnit.SECONDS).toString();
                println(response)
                return response

            } catch (e : Exception) {
                println(e.toString())
            }
            return "Sin respuesta"
        }
        public fun callWeatherApiAsyng(con :Context,recycler: RecyclerView )
        {

            val queue = Volley.newRequestQueue(con)
            print("Entra en provincias")
            val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, "https://www.el-tiempo.net/api/json/v2/provincias", JSONObject(),
                { response ->

                     var provincias = response["provincias"] as JSONArray
                    val lista = Provincia.fromJson(provincias.toString())
                    if (lista != null) {
                        print("Provincias encontradas " + lista.size.toString())
                        val mAdapter = Adaptador(lista)
                        recycler.adapter = mAdapter
                    }
                  },
                Response.ErrorListener {error ->  println("That didn't work!" + error.toString()) })


            try {
                queue.add(jsonObjectRequest)


            } catch (e : Exception) {
                println("ERRR" + e.toString())
            }

        }
        public fun getProvinciaDetalle(con :Context,recycler: RecyclerView )
        {

            val queue = Volley.newRequestQueue(con)
            val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, "https://www.el-tiempo.net/api/json/v2/provincias/01", JSONObject(),
                { response ->

                    var provincias = response["provincias"] as JSONArray
                    val lista = Provincia.fromJson(provincias.toString())
                    if (lista != null) {
                        print("Provincias encontradas " + lista.size.toString())
                        val mAdapter = Adaptador(lista)
                        recycler.adapter = mAdapter
                    }
                },
                Response.ErrorListener {error ->  println("That didn't work!" + error.toString()) })


            try {
                queue.add(jsonObjectRequest)


            } catch (e : Exception) {
                println("ERRR" + e.toString())
            }

        }
    }



}