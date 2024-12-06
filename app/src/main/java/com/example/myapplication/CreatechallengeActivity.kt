package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreatechallengeActivity : AppCompatActivity() {
    private lateinit var nama: EditText
    private lateinit var komp1: EditText
    private lateinit var komp2: EditText
    private lateinit var komp3: EditText
    private lateinit var komp4: EditText
    private lateinit var komp5: EditText
    private lateinit var komp6: EditText
    private lateinit var komp7: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_createchallenge)

        val kembali = findViewById<Button>(R.id.kembali)
        val lanjut = findViewById<Button>(R.id.lanjut)

        nama = findViewById<EditText>(R.id.nama)
        komp1 = findViewById<EditText>(R.id.komp1)
        komp2 = findViewById<EditText>(R.id.komp2)
        komp3 = findViewById<EditText>(R.id.komp3)
        komp4 = findViewById<EditText>(R.id.komp4)
        komp5 = findViewById<EditText>(R.id.komp5)
        komp6 = findViewById<EditText>(R.id.komp6)
        komp7 = findViewById<EditText>(R.id.komp7)


        kembali.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        lanjut.setOnClickListener {
            if (vallidateForm()) {
                val intent = Intent(this, TargetinfoActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Isi Nama dan minimal 3 Kompetitor", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun vallidateForm(): Boolean {
        val nama = nama.text.toString().trim()
        val komp1 = komp1.text.toString().trim()
        val komp2 = komp2.text.toString().trim()
        val komp3 = komp3.text.toString().trim()
        val komp4 = komp4.text.toString().trim()
        val komp5 = komp5.text.toString().trim()
        val komp6 = komp6.text.toString().trim()
        val komp7 = komp7.text.toString().trim()

        if (nama.isEmpty()|| komp1.isEmpty() || komp2.isEmpty() || komp3.isEmpty()) {
            Toast.makeText(this, "Isi Nama dan minimal 3 Kompetitor", Toast.LENGTH_SHORT)
                .show()
            return false
        }
    return true
    }
}
