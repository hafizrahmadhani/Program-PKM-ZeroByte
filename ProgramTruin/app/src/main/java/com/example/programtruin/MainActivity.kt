package com.example.programtruin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    var btnAdmin: Button? = null
    var btnUser: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.hide()
        }


        btnAdmin = findViewById<View>(R.id.Admin) as Button
        btnUser= findViewById<View>(R.id.User) as Button

        btnAdmin!!.setOnClickListener{
            var intentAdmin = Intent(this, LoginActivity::class.java)
            startActivity(intentAdmin)
        }
        btnUser!!.setOnClickListener{
            var intentUser = Intent(this, MenuActivity::class.java)
            startActivity(intentUser)
        }
    }
}