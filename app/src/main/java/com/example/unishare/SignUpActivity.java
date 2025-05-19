package com.example.unishare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;

public class SignUpActivity extends AppCompatActivity {


    EditText signupName, signupEmail, signupUsername, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRendirectText);

       signupButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               database = FirebaseDatabase.getInstance();
               reference = database.getReference("users");

               String name = signupName.getText().toString();
               String email = signupEmail.getText().toString();
               String username = signupUsername.getText().toString();
               String password = signupPassword.getText().toString();

               HelperClass helperClass = new HelperClass(name, email, username, password);
               reference.child(username).setValue(helperClass);

               Toast.makeText(SignUpActivity.this, "You have been signup successfully!", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
               startActivity(intent);
           }
       });

        loginRedirectText.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}