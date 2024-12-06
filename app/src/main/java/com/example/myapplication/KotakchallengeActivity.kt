package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KotakchallengeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kotakchallenge)
        val ChallengeAktif =  findViewById<Button>(R.id.challengeAktif)
        ChallengeAktif.setOnClickListener{
            val intent = Intent(this, ChallengeaktifActivity::class.java)
            startActivity(intent)
        }
    }
}