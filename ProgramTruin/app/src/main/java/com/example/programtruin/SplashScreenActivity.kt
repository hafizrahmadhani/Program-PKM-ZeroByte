package com.example.programtruin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.hide()
        }

        val SPLASH_DISPLAY_LENGTH = 5000
        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            this@SplashScreenActivity.startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}