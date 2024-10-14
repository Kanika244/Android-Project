package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Initializing Views
        val detailsImage: ImageView = findViewById(R.id.experience_image)
        val bookNowButton: Button = findViewById(R.id.book_experience_button)

        // Set a click listener for the Book Now Button
        bookNowButton.setOnClickListener {
            // Perform booking action here (e.g., navigate to a booking page or show a confirmation)
            val intent = Intent(this, ActivityPayment::class.java)
            startActivity(intent)
        }

        // If you want to pass specific data (like hike details) from the previous activity,
        // you can do so using intents. Example:
        val hikeName = intent.getStringExtra("hike_name")
        val hikeDate = intent.getStringExtra("hike_date")
        val hikePrice = intent.getStringExtra("hike_price")

        // Set the passed data (optional)
        val hikeDateTextView: TextView = findViewById(R.id.experience_location)
        hikeDateTextView.text = "Hike Date: $hikeDate"

        val hikePriceTextView: TextView = findViewById(R.id.experience_price)
        hikePriceTextView.text = "Price: $hikePrice"
    }
}
