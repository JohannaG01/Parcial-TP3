package com.example.parcial_tp3.APIServiceBuilder

import com.example.parcial_tp3.Model.CarResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CarService {
    @GET("cars?make=Mercedes")
    fun getCars(@Query("make") brand: String): Call<List<CarResponse>>
}