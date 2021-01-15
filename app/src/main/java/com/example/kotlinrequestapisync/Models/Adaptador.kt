package com.example.kotlinrequestapisync.Models


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinrequestapisync.MainActivity2
import com.example.kotlinrequestapisync.R



internal class Adaptador(
    private val provincias: List<Provincia>,
   ):RecyclerView.Adapter<Adaptador.MyViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Adaptador.MyViewHolder {
        val v = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.weather_list, viewGroup, false);
        return MyViewHolder(v)
    }


    override fun getItemCount() = provincias.size

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {

        p0.id.text = provincias[p1].cod
        p0.nombre.text = provincias[p1].nombre


    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var id: TextView = view.findViewById(R.id.provinciaID)
        var nombre: TextView = view.findViewById(R.id.provinciaName)


        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View) {
            val position = adapterPosition
            val intent =  Intent(p0.context, MainActivity2::class.java)
            p0.context.startActivity(intent)

        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}







