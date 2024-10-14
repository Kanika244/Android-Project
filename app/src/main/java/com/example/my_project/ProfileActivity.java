package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Custom Back Button (UI back button)
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Call system back press when the back button is clicked
            }
        });

        // Settings Button
        ImageView settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Settings Activity
            }
        });

        // Edit Profile Button
        Button editProfileButton = findViewById(R.id.edit_profile_button);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Edit Profile Activity
            }
        });

        // Load user data dynamically
        loadUserProfile();
    }

    private void loadUserProfile() {
        // Example: Set user name and email dynamically
        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        String userEmail = intent.getStringExtra("USER_EMAIL");
        TextView userNameTextView = findViewById(R.id.user_name);
        TextView userEmailTextView = findViewById(R.id.user_email);
        if (userName != null) {
            userNameTextView.setText(userName);
        }
        if (userEmail != null) {
            userEmailTextView.setText(userEmail);
        }
    }


    // Override the onBackPressed method to handle back navigation
    @Override
    public void onBackPressed() {
        // You can add custom behavior here if needed, or simply call super to go back
        super.onBackPressed(); // Calls the default back navigation behavior
    }
}
