package com.example.parcial_tp3.APIServiceBuilder

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIServiceBuilder {
    private const val BASE_URL = "https://api.api-ninjas.com/v1/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val modifiedRequest = originalRequest.newBuilder()
                .header("X-Api-Key", "GKj4p0jtTolV6NZpbdFdIw==EQUGDSvpIREDYFKn")
                .build()
            chain.proceed(modifiedRequest)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun create(): CarService {
        return retrofit.create(CarService::class.java)
    }
}
