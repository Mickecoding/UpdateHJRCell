package com.example.loginregisterrelative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.loginregisterrelative.databinding.ActivityLoginBinding
import com.example.loginregisterrelative.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class   RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.buttonRegister.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editTextTextPassword2.text.toString()



            if (email.isEmpty()) {
                binding.editEmail.error = "Isi lah Email nya"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editEmail.error = "Diisi Dulu loh"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.editTextTextPassword2.error = "Isi Password"
                binding.editTextTextPassword2.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 5) {
                binding.editTextTextPassword2.error = "Password Minimal 5 Karakter"
                binding.editTextTextPassword2.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email,password)

        }

    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Alhamdulillah  Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,Login::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}