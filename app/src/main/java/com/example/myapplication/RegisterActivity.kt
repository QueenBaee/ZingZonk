package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import  android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.content.Intent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.mindrot.jbcrypt.BCrypt

class RegisterActivity : AppCompatActivity() {
    private lateinit var dbHelper : DatabaseHelper
    private lateinit var Utils : Utils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        dbHelper = DatabaseHelper(this)
        val etUsername = findViewById<EditText>(R.id.username)
        val etPassword = findViewById<EditText>(R.id.password)
        val btnRegister = findViewById<Button>(R.id.btnRegister)


       btnRegister.setOnClickListener{
           val username = etUsername.text.toString().trim()
           val password = etPassword.text.toString().trim()

           if (username.isEmpty() || password.isEmpty()){
               Toast.makeText(this, "Isername dan password tidak boleh kosong", Toast.LENGTH_SHORT).show()
               }else{
               val hashedPassword = Utils.hashPassword(password)
               if(dbHelper.loginUser(username,hashedPassword)){
                   Toast.makeText(this,"Login Berhasil", Toast.LENGTH_SHORT).show()
                   startActivity(Intent(this, HomeActivity::class.java))
                   finish()
               }else{
                   Toast.makeText(this,"Login Gagal, Username atau password salah", Toast.LENGTH_SHORT).show()
               }
           }
           }
       }

}