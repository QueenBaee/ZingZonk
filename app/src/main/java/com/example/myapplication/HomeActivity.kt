package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val buatChallenge = findViewById<Button>(R.id.buatChallenge)
        buatChallenge.setOnClickListener {
            val intent = Intent(this, CreatechallengeActivity::class.java)
            startActivity(intent)
        }
        val kotakChallenge =  findViewById<Button>(R.id.kotakChallenge)
        kotakChallenge.setOnClickListener{
            val intent = Intent(this, KotakchallengeActivity::class.java)
            startActivity(intent)
        }
        }
    }
