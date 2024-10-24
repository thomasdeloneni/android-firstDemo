package com.example.mod3demo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etname = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)

        val button = findViewById<Button>(R.id.btnSubmit)

        button.setOnClickListener {
            val name = etname.text.toString()
            val age = etAge.text.toString()

            Toast.makeText(this, "Bonjour $name, tu as $age ans", Toast.LENGTH_SHORT).show()
        }
    }
}