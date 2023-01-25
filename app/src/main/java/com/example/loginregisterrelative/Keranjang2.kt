package com.example.loginregisterrelative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Keranjang2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang2)
    }

    fun back(view: View?) {
        val i = Intent(applicationContext, Beli2::class.java)
        startActivity(i)
    }

    fun krj(view: View?) {
        val i = Intent(applicationContext, CekOut2::class.java)
        startActivity(i)
    }
}