package com.example.imad_a2final

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startbtn = findViewById<Button>(R.id.startBtn)
        startbtn.setOnClickListener {
            // create the explicit intent
            val intent = Intent(this, MainActivity2::class.java)
            // start your next activity
            startActivity(intent)

        }
    }
}