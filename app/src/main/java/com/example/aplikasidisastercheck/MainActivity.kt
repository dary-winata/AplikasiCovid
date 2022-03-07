package com.example.aplikasidisastercheck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnLanjut)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, NewsActivity::class.java)
            this.startActivity(intent)
        }
    }
}