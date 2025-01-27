package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class AboutUsActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_aboutus)

            val contactUsLink: TextView = findViewById(R.id.linkContactUs)

            // Set a click listener to navigate to ContactUsActivity
            contactUsLink.setOnClickListener {
                val intent = Intent(this, ContactUsActivity::class.java)
                startActivity(intent)
            }
        }
    }

