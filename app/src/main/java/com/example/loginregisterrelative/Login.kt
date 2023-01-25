package com.example.loginregisterrelative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.loginregisterrelative.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityLoginBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.textView5.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.buttonMasuk.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            if (email.isEmpty()) {
                binding.editTextTextEmailAddress.error = "Isi Email"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editTextTextEmailAddress.error = "Isi Email Terlebih dahulu"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.editTextTextPassword.error = "Isi Password"
                binding.editTextTextPassword.requestFocus()
                return@setOnClickListener
            }
            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Selamat Datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,HompageHJR::class.java)
                    intent.putExtra("email","$email")
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}",Toast.LENGTH_SHORT).show()
                }
            }
    }
}