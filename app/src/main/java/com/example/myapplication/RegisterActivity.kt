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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val etUsername = findViewById<EditText>(R.id.username)
        val etPassword = findViewById<EditText>(R.id.password)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val db = AppDatabase.getDatabase(applicationContext)
        val userDao = db.UserDao()

       btnRegister.setOnClickListener{
           val username = etUsername.text.toString()
           val password = etPassword.text.toString()

           val hashedPassword = hashPassword(password)
           lifecycleScope.launch{
               val existingUser = userDao.getUserByUsername(username)
               if (existingUser == null){
                   val  newUser =User(username = username, password = hashedPassword)
                   userDao.InsertUser(newUser)

                   runOnUiThread{
                       Toast.makeText(applicationContext, "Registration successful!", Toast.LENGTH_SHORT).show()
                   }
                   val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                   startActivity(intent)
                   finish()
               }else{
                   runOnUiThread{
                       Toast.makeText(applicationContext, "Username already exists!", Toast.LENGTH_SHORT).show()
                   }
               }
           }
       }
    }

    private  fun hashPassword(password: String):String{
        return BCrypt.hashpw(password, BCrypt.gensalt(12))
    }
}