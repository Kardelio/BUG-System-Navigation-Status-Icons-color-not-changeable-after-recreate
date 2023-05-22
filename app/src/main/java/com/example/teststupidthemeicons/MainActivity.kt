package com.example.teststupidthemeicons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.darkb).setOnClickListener {

            toggle(false)
        }
        findViewById<Button>(R.id.lightb).setOnClickListener {
            toggle(true)
        }
        findViewById<Button>(R.id.toga).setOnClickListener {

            bu(true)
        }
        findViewById<Button>(R.id.togb).setOnClickListener {
            bu(false)
        }
    }

    fun bu(d: Boolean) {
        //NOTE: the below commented out code also doesnt work
        window.decorView.systemUiVisibility = if (d) {
            window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = d
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightNavigationBars =
            d
    }

    private fun toggle(f: Boolean) {
        if (f) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        } else {

            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        }

    }
}