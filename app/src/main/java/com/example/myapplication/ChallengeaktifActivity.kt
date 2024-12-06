package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChallengeaktifActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_challengeaktif)
        val Menu =  findViewById<Button>(R.id.Menu)
        val yellow = findViewById<Button>(R.id.detailsButton1)
        yellow.setOnClickListener{
            val intent = Intent(this, YellowstardetailActivity::class.java)
            startActivity(intent)
        }
        val grey = findViewById<Button>(R.id.detailsButton2)
        grey.setOnClickListener{
            val intent = Intent(this, GreystardetailActivity::class.java)
            startActivity(intent)
        }
        val blue = findViewById<Button>(R.id.detailsButton3)
        blue.setOnClickListener{
            val intent = Intent(this, BluestardetailActivity::class.java)
            startActivity(intent)
        }
        val green = findViewById<Button>(R.id.detailsButton4)
        green.setOnClickListener{
            val intent = Intent(this, GreenstardetailActivity::class.java)
            startActivity(intent)
        }
        val red = findViewById<Button>(R.id.detailsButton5)
        red.setOnClickListener{
            val intent = Intent(this, RedstardetailActivity::class.java)
            startActivity(intent)
        }
        Menu.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}