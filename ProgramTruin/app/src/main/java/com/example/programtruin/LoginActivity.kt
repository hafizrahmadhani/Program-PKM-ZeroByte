package com.example.programtruin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    var username: EditText? = null
    var password: EditText? = null
    var btnMasuk: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        username = findViewById<View>(R.id.username) as EditText
        password = findViewById<View>(R.id.password) as EditText
        btnMasuk = findViewById<View>(R.id.btnMasuk) as Button
        btnMasuk!!.setOnClickListener {
            val usernameKey = username!!.text.toString()
            val passwordKey = password!!.text.toString()
            if (usernameKey == "admin" && passwordKey == "admin") {
                //jika login berhasil
                Toast.makeText(
                    applicationContext, "LOGIN SUKSES",
                    Toast.LENGTH_SHORT
                ).show()
                var intentMenu = Intent(this, MenuActivity::class.java)
                startActivity(intentMenu)
            } else {
                //jika login gagal
                val builder: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@LoginActivity)
                builder.setMessage("Username atau Password Anda salah")
                    .setNegativeButton("Retry", null).create().show()
            }
        }
    }
}