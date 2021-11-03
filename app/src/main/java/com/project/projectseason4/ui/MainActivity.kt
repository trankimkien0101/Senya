package com.project.projectseason4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.project.projectseason4.R
import com.project.projectseason4.data.Attraction
import com.project.projectseason4.data.AttractionResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()


    val attractionList: List<Attraction> by lazy {
        parseAttraction()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostfragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun parseAttraction(): List<Attraction> {
        val textFromFile = resources.openRawResource(R.raw.croatia).bufferedReader().use { it.readText() }


        val adapter: JsonAdapter<AttractionResponse> = moshi.adapter(AttractionResponse::class.java)
        return adapter.fromJson(textFromFile)!!.attractions
    }
}