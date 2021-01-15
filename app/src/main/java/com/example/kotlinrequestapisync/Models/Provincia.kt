package com.example.kotlinrequestapisync.Models

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon

private val klaxon = Klaxon()

data class Provincia(
     @Json(name = "CODPROV")
        val cod : String,
     @Json(name = "NOMBRE_PROVINCIA")
        val nombre : String


){
        companion object {
                public fun fromJson(json: String) = klaxon.parseArray<Provincia>(json)
        }
}

