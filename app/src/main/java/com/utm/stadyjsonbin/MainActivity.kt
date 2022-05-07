package com.utm.stadyjsonbin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.utm.stadyjsonbin.api.MenuApiService
import com.utm.stadyjsonbin.model.Menu

class MainActivity : AppCompatActivity() {
    lateinit var nameText: TextView
    lateinit var categoryText: TextView
    lateinit var priceText: TextView
    lateinit var weightText: TextView
    lateinit var amountText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }

    private fun loadData() {
        Log.d("API", "loadData")
        val service = MenuApiService()
        service.getLocalMenu(object : MenuApiService.MenuCallback {
            override fun onSuccess(menu: Menu) {
                displayMenu(menu)
            }
            override fun onFailure() {
                Log.d("API", "error loading data")
            }
        })
    }

    private fun displayMenu(menu: Menu) {
        val name = menu.name
        val category = menu.category
        val price = menu.price
        val weight = menu.weight
        val amount = menu.amount

        Log.d("API", "$name")
        Log.d("API", "$category")
        Log.d("API", "$price")
        Log.d("API", "$weight")
        Log.d("API", "$amount")

        initView()

        nameText.text = name
        categoryText.text = "Category: $category"
        priceText.text = "Price: $price UAH"
        weightText.text = "Weight: $weight kg"
        amountText.text = "Amount: $amount"
    }

    private fun initView() {
        nameText = findViewById(R.id.food_name)
        categoryText = findViewById(R.id.food_category)
        priceText = findViewById(R.id.food_price)
        weightText = findViewById(R.id.food_weight)
        amountText = findViewById(R.id.food_amount)
    }
}