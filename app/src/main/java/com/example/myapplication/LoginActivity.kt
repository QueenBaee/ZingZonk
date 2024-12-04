package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.mindrot.jbcrypt.BCrypt


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.button)
        val registerButton = findViewById<Button>(R.id.tvRegister)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            lifecycleScope.launch{
                val user = userDao.getUserByUsername(username)
                if (user != null){
                    if (checkPassword(password,user.password)){
                        runOnUiThread{
                            Toast.makeText(applicationContext,"Login Berhasil",Toast.LENGTH_SHORT).show()
                        }
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        runOnUiThread{
                            Toast.makeText(applicationContext,"Password Salah",Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    runOnUiThread{
                        Toast.makeText(applicationContext,"Username tidak ditemukan",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            registerButton.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
private fun checkPassword (inputPassword: String, storedHash: String): Boolean{
    return BCrypt.checkpw(inputPassword,storedHash)
}
