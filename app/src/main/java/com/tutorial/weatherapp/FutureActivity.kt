package com.tutorial.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.weatherapp.Adapters.FutureAdapters
import com.tutorial.weatherapp.Domains.Future

class FutureActivity : ComponentActivity() {
    private lateinit var adapterTommorow: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_WeatherApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_future)

        initRecyclerView()
        setVariable()
    }

    private fun setVariable() {
        val backBtn = findViewById<ConstraintLayout>(R.id.backbtn)
        backBtn.setOnClickListener{
            startActivity(Intent(this@FutureActivity, MainActivity::class.java))
        }
    }

    private fun initRecyclerView() {
        val items = ArrayList<Future>()

        items.add(
            Future(
                "Sat",
                "storm",
                "storm",
                25,
                10
            )
        )
        items.add(
            Future(
                "Sun",
                "cloudy",
                "cloudy",
                24,
                16
            )
        )
        items.add(
            Future(
                "Mon",
                "windy",
                "windy",
                29,
                15
            )
        )
        items.add(
            Future(
                "Tue",
                "cloudy_sunny",
                "Cloudy_Sunny",
                22,
                13
            )
        )
        items.add(
            Future(
                "Wen",
                "sunny",
                "Sunny",
                28,
                11
            )
        )
        items.add(
            Future(
                "Thu",
                "rainy",
                "Rainy",
                23,
                12
            )
        )

        recyclerView = findViewById(R.id.recyclerview2)

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        adapterTommorow = FutureAdapters(items, this)
        recyclerView.adapter = adapterTommorow


    }
}