package com.utm.stadyjsonbin.api

import com.utm.stadyjsonbin.model.Menu
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenuApiService {

    var api: MenuApi

    companion object {
        const val SECRET_KEY = "\$2b\$10\$2zdZeI6/Z/IV.pHuzOHLsedEGIidAhHnrz1cRfb84hlTgmI9q8WC6"
    }

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(MenuApi::class.java)
    }

    fun getLocalMenu(callback: MenuCallback) {
        api.getLocalMenu(SECRET_KEY).enqueue(object : Callback<Menu> {
            override fun onResponse(call: Call<Menu>, response:

            Response<Menu>
            ) {

                if (response.code() == 200 && response.body() != null)
                    callback.onSuccess(response.body()!!)
                else
                    callback.onFailure()
            }
            override fun onFailure(call: Call<Menu>, t: Throwable) {
                callback.onFailure()
            }
        })
    }

    interface MenuCallback {
        fun onSuccess(weather: Menu)
        fun onFailure()
    }
}