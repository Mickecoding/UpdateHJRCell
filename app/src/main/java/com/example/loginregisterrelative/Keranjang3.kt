package com.example.loginregisterrelative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Keranjang3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang3)
    }

    fun back(view: View?) {
        val i = Intent(applicationContext, Beli3::class.java)
        startActivity(i)
    }

    fun krj(view: View?) {
        val i = Intent(applicationContext, CekOut3::class.java)
        startActivity(i)
    }
}