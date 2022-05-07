package com.utm.stadyjsonbin.api

import com.utm.stadyjsonbin.model.Menu
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface MenuApi {
    @GET("b/627676eb019db46796973fa0/1")
    fun getLocalMenu(@Header("secret-key") secretKey: String): Call<Menu>
}