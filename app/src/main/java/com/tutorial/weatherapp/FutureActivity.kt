package com.tutorial.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.weatherapp.Adapters.FutureAdapters
import com.tutorial.weatherapp.Domains.FutureDomain

class FutureActivity : AppCompatActivity() {
    private lateinit var adapterTommorow: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_future)

//        initRecyclerView()
//        setVariable()
    }

    private fun setVariable() {
        var backBtn = findViewById<ConstraintLayout>(R.id.backbtn)
        backBtn.setOnClickListener{
            startActivity(Intent(this@FutureActivity, MainActivity::class.java))
        }
    }

    private fun initRecyclerView() {
        var items = ArrayList<FutureDomain>()

        items.add(FutureDomain("Sat", "storm", "storm", 25, 10))
        items.add(FutureDomain("Sun", "cloudy", "cloudy", 24, 16))
        items.add(FutureDomain("Mon", "windy", "windy", 29, 15))
        items.add(FutureDomain("Tue", "cloudy_sunny", "Cloudy_Sunny", 22, 13))
        items.add(FutureDomain("Wen", "sunny", "Sunny", 28, 11))
        items.add(FutureDomain("Thu", "rainy", "Rainy", 23, 12))

        recyclerView = findViewById(R.id.recyclerview2)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        adapterTommorow = FutureAdapters(items, this)

        recyclerView.adapter = adapterTommorow


    }
}