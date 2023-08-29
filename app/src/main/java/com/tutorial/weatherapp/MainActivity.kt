package com.tutorial.weatherapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.weatherapp.Adapters.HourlyAdapters
import com.tutorial.weatherapp.Domains.Hourly

class MainActivity: ComponentActivity() {
    private lateinit var adapterHourly: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        initRecyclerView()
        setVariable()
    }

    private fun setVariable() {
        val nextBtn = findViewById<TextView>(R.id.nextBtn)
        val listener = View.OnClickListener {
            startActivity(Intent(this@MainActivity, FutureActivity::class.java))
        }
        nextBtn.setOnClickListener(listener)


    }

    private fun initRecyclerView() {
        val items = ArrayList<Hourly>()

        items.add(Hourly("9 am", 28, "cloudy"))
        items.add(Hourly("11 pm", 29, "sunny"))
        items.add(Hourly("12 pm", 30, "wind"))
        items.add(Hourly("1 am", 29, "rainy"))
        items.add(Hourly("2 am", 27, "storm"))

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
            )

        adapterHourly = HourlyAdapters(items, this)
        recyclerView.adapter = adapterHourly
    }

}