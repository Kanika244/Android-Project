package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContactUsActvitypackage

class ContactUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactus)

        val submitButton: Button = findViewById(R.id.buttonSubmit)
        val backButton: Button = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
            finish() // Optionally, to prevent returning to Contact Us page
        }
        submitButton.setOnClickListener {
            // Logic to handle form submission, e.g., display a Toast or send data to server
            Toast.makeText(this, "Message Sent!", Toast.LENGTH_SHORT).show()
        }
    }
}

