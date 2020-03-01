package com.ssepulveda.geoapp.base

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){

    fun onStartActivity(activity: Class<*>, isClose: Boolean){
        val startIntent = Intent(this, activity)
        startActivity(startIntent)
        if (isClose) finish()
    }
}