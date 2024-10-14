package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        dbHelper = DBHelper(this)

        // Initialize views
        val nameEditText = findViewById<EditText>(R.id.signup_name)
        val emailEditText = findViewById<EditText>(R.id.signup_email)
        val createPasswordEditText = findViewById<EditText>(R.id.create_pass)
        val confirmPasswordEditText = findViewById<EditText>(R.id.signup_confirm_password)
        val signupButton = findViewById<Button>(R.id.signup_button)
        val loginButton = findViewById<Button>(R.id.login_button)

        // Handle Signup Button click
        signupButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val createPassword = createPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            // Check if any field is empty
            if (name.isNotEmpty() && email.isNotEmpty() && createPassword.isNotEmpty() && createPassword == confirmPassword) {
                val userId = dbHelper.insertUser(name, email, createPassword)
                if (userId > -1) {
                    // Save the login state
                    val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putBoolean("isLoggedIn", true)
                    editor.putString("username", name) // Save the username or email
                    editor.putString("password", createPassword) // Save the password (consider security implications)
                    editor.apply() // Save changes

                    Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Signup failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields and ensure passwords match", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle Login Button click to return to the Login page
        loginButton.setOnClickListener {
            // Go back to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
