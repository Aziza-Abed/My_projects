package com.example.allyrgywiseapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogInActivity extends AppCompatActivity {
    private Button btnlogin;
    private EditText edtemail;
    private EditText edtpassword;

    private final String myEMAIL = "azezehabed@gmail.com"; // Example email
    private final String myPASSWORD = "1"; // Example password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Initializes
        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setBackgroundColor(Color.parseColor("#e0ae77"));
        edtemail = findViewById(R.id.edtemail);
        edtpassword = findViewById(R.id.edtpassword);

        //handling login
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtemail.getText().toString();
                String password = edtpassword.getText().toString();

                // check correctness of email and password
                if (!email.equals(myEMAIL) || !password.equals(myPASSWORD) || !email.contains("@gmail.com")) {
                    // Failed login
                    Toast.makeText(LogInActivity.this, "Failed Login. Try Again ^_^", Toast.LENGTH_SHORT).show();
                } else {
                    // Successful login
                    Toast.makeText(LogInActivity.this, "Successful Login.", Toast.LENGTH_SHORT).show();

                    // Passing email value to UserProfileActivity
                    Intent intent = new Intent(LogInActivity.this, WhatTheSystemProvideActivity.class);
                    intent.putExtra("ProfileAccess", true);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
