package com.example.loginregisterrelative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun masuk(view: View?) {
        val i = Intent(applicationContext, Login::class.java)
        startActivity(i)
    }

    fun registrasi(view: View?) {
        val i = Intent(applicationContext, RegisterActivity::class.java)
        startActivity(i)
    }
}