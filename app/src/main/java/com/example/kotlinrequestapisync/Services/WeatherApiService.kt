package com.example.kotlinrequestapisync.Services

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.lang.Exception
import java.util.concurrent.TimeUnit

class WeatherApiService {
    companion object{

        public fun callWeatherApi(con :Context) : String
        {
            val queue = Volley.newRequestQueue(con)
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
        public fun callWeatherApiAsyng(con :Context) : String
        {
            val queue = Volley.newRequestQueue(con)
            var respuesta = ""
            val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, "https://www.el-tiempo.net/api/json/v2/home", JSONObject(),
                // val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, "http://192.168.189.91:8091/api/StockPicking", parameters,
                 { response ->

                    print("Response is: ${response.toString()}")
                     respuesta = "SERVICIO" +  response.toString()
                },
                Response.ErrorListener {error ->  println("That didn't work!" + error.toString()) })


            try {
                queue.add(jsonObjectRequest)
                return respuesta

            } catch (e : Exception) {
                println("ERRR" + e.toString())
            }
            return "Sin respuesta"
        }
    }
}