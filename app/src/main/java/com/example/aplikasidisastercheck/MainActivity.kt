package com.example.aplikasidisastercheck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnLanjut)
        spinner = findViewById(R.id.spinnerKota)
        button.setOnClickListener {
            globalString.user_state = spinner.selectedItem.toString()
            Log.d("testing", "${globalString.user_state}")
            val intent = Intent(this@MainActivity, NewsActivity::class.java)
            this.startActivity(intent)
        }
    }
}