package com.example.loginregisterrelative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Contact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
    }
    fun back(view: View?) {
        val i = Intent(applicationContext, HompageHJR::class.java)
        startActivity(i)
    }

    fun kirim(view: View?) {
        val i = Intent(applicationContext, HompageHJR::class.java)
        startActivity(i)
    }

    fun home(view: View?) {
        val i = Intent(applicationContext, HompageHJR::class.java)
        startActivity(i)
    }

    fun kategori(view: View?) {
        val i = Intent(applicationContext, kategori::class.java)
        startActivity(i)
    }

    fun about(view: View?) {
        val i = Intent(applicationContext, About::class.java)
        startActivity(i)
    }

    fun profile(view: View?) {
        val i = Intent(applicationContext, Contact::class.java)
        startActivity(i)
    }
}