package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewchallengeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reviewchallenge)
        val kembali = findViewById<Button>(R.id.kembali)
        val lanjut = findViewById<Button>(R.id.kirim)
        kembali.setOnClickListener {
            val intent = Intent(this, TargetinfoActivity::class.java)
            startActivity(intent)
        }
        lanjut.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}




