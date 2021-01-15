package com.example.kotlinrequestapisync.Models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinrequestapisync.R


internal class Adaptador(private val provincias: List<Provincia>,val context: Context):
    RecyclerView.Adapter<Adaptador.MyViewHolder>() {
    private val lista : List<Provincia> ?= null

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var id: TextView = view.findViewById(R.id.provinciaID)
        var nombre: TextView = view.findViewById(R.id.provinciaName)

    }
 override fun onCreateViewHolder(viewGroup : ViewGroup , i: Int): Adaptador.MyViewHolder {
        val v = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.weather_list, viewGroup, false);
        return  MyViewHolder(v)
    }


override fun getItemCount() = provincias.size
    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
       val provincia = provincias[p1]
        p0.id.text = provincias[p1].cod
        p0.nombre.text = provincias[p1].nombre
    }


    //3



}
