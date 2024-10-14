package com.example.myapplication


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonBookNow1 = findViewById<Button>(R.id.buttonBookNow1)
        val buttonBookNow2 = findViewById<Button>(R.id.buttonBookNow2)
        val buttonBookNow3 = findViewById<Button>(R.id.buttonBookNow3)
        val buttonBookNow4 = findViewById<Button>(R.id.buttonBookNow4)

        buttonBookNow1.setOnClickListener {
            openActivityDetails()
        }

        buttonBookNow2.setOnClickListener {
            openActivityDetails()
        }

        buttonBookNow3.setOnClickListener {
            openActivityDetails()
        }

        buttonBookNow4.setOnClickListener {
            openActivityDetails()
        }










        drawerLayout = findViewById(R.id.main)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)


        findViewById<View>(R.id.menu_icon).setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_profile -> Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT)
                    .show()

                R.id.nav_settings -> {
                    // Open the SettingsActivity
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_logout -> {val intent = Intent(this, LogoutActivity::class.java)
                startActivity(intent)
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }




        val userName = intent.getStringExtra("user_name")
        val userNameTextView = findViewById<TextView>(R.id.user_name_text_view)
        if (userName != null) {
            userNameTextView.text = "$userName"
        }

        val exploreNowButton: Button = findViewById(R.id.exploreNowButton)
        exploreNowButton.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bookNowButton: Button = findViewById(R.id.buttonBookNow1)
        bookNowButton.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("hike_name", "Mountain Hike")
            intent.putExtra("hike_date", "June 15, 2024")
            intent.putExtra("hike_price", "$150")
            startActivity(intent)
        }

        val avatarImageView = findViewById<ImageView>(R.id.avatar_image)

        avatarImageView.setOnClickListener {
            // Open LoginActivity when the avatar is clicked
            val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

            if (isLoggedIn) {
                // User is logged in, navigate to ProfileActivity
                val userName = sharedPreferences.getString("user_name", "")
                val userEmail = sharedPreferences.getString("user_email", "")
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("user_name", userName)
                intent.putExtra("user_email", userEmail)
                startActivity(intent)
            } else {
                // User is not logged in, navigate to LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }


    }

    private fun openActivityDetails() {
        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }

    fun sendEmail(view: View) {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:kanikajain0610@gmail.com.com")
        }
        startActivity(Intent.createChooser(emailIntent, "Send email"))
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}