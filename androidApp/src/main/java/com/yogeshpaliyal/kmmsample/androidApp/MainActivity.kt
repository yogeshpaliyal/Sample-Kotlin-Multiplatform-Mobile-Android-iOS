package com.yogeshpaliyal.kmmsample.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.yogeshpaliyal.kmmsample.shared.Greeting
import com.yogeshpaliyal.kmmsample.shared.SampleCaller
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch(Dispatchers.IO){
            val response = SampleCaller().callApi()
            withContext(Dispatchers.Main){
                val tv: TextView = findViewById(R.id.text_view)
                tv.text = response.toString()
            }
        }


    }
}
