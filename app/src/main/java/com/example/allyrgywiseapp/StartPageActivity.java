package com.example.allyrgywiseapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartPageActivity extends AppCompatActivity {
    private Button btncheck;
    private Button btnsignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_page);
        // Initializes
        btnsignin = findViewById(R.id.btnsignin);
        btnsignin.setBackgroundColor(Color.parseColor("#e0ae77"));
        btncheck = findViewById(R.id.btncheck);
        btncheck.setBackgroundColor(Color.parseColor("#e0ae77"));

        //handle sign in button
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPageActivity.this, LogInActivity.class);
                intent.putExtra("ProfileAccess", true);// Allows profile access on login
                startActivity(intent);

            }
        });
        //handle check button
        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPageActivity.this, WhatTheSystemProvideActivity.class);
                intent.putExtra("ProfileAccess", false);// Disables profile access
                startActivity(intent);

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}