package com.example.unishare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView profileName, profileEmail, profileUsername, profilePassword;
    TextView titleName, titleUsername;
    Button editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileUsername = findViewById(R.id.profileUsername);
        profilePassword = findViewById(R.id.profilePassword);
        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUsername);
        editProfile = findViewById(R.id.editButton);

        loadUserData();

        editProfile.setOnClickListener(view -> passUserData());
    }

    public void loadUserData() {

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);


        String nameFromPrefs = sharedPreferences.getString("name", "Unknown User");
        String emailFromPrefs = sharedPreferences.getString("email", "Not Available");
        String usernameFromPrefs = sharedPreferences.getString("username", "No Username");
        String passwordFromPrefs = sharedPreferences.getString("password", "No Password");


        titleName.setText(nameFromPrefs);
        titleUsername.setText(usernameFromPrefs);
        profileName.setText(nameFromPrefs);
        profileEmail.setText(emailFromPrefs);
        profileUsername.setText(usernameFromPrefs);
        profilePassword.setText(passwordFromPrefs);
    }

    public void passUserData() {

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String nameFromPrefs = sharedPreferences.getString("name", "Unknown User");
        String emailFromPrefs = sharedPreferences.getString("email", "Not Available");
        String usernameFromPrefs = sharedPreferences.getString("username", "No Username");
        String passwordFromPrefs = sharedPreferences.getString("password", "No Password");


        Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
        intent.putExtra("name", nameFromPrefs);
        intent.putExtra("email", emailFromPrefs);
        intent.putExtra("username", usernameFromPrefs);
        intent.putExtra("password", passwordFromPrefs);
        startActivity(intent);
    }
}
