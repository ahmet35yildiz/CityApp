package com.example.cityapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var keepSplashOnScreen = true
        val delay = 2000L

        installSplashScreen().setKeepOnScreenCondition { keepSplashOnScreen }
        Handler(Looper.getMainLooper()).postDelayed({ keepSplashOnScreen = false }, delay)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}