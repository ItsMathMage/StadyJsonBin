package com.utm.stadyjsonbin.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Menu {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("category")
    @Expose
    var category: String? = null

    @SerializedName("price")
    @Expose
    var price: Int? = null

    @SerializedName("weight")
    @Expose
    var weight: Int? = null

    @SerializedName("amount")
    @Expose
    var amount: Int? = null
}