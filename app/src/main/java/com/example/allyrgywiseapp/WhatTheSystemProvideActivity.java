package com.example.allyrgywiseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WhatTheSystemProvideActivity extends AppCompatActivity {
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_what_the_system_provide);

        // return whether profile access is allowed
        boolean ProfileAccess = getIntent().getBooleanExtra("ProfileAccess", false);

        // Get the email if it was passed from the previous activity
        email = getIntent().getStringExtra("email");

        // set an item click listener for the ListView options
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0: // "What is an Allergy?"
                        intent = new Intent(WhatTheSystemProvideActivity.this, WhatIsAllergyActivity.class);
                        break;
                    case 1: // "Types of Allergies"
                        intent = new Intent(WhatTheSystemProvideActivity.this, TypesOfAllergiesActivity.class);
                        break;
                    case 2: // "How to Diagnose Allergies?"
                        intent = new Intent(WhatTheSystemProvideActivity.this, DiagnoseAllergiesActivity.class);
                        break;
                    case 3:// "Your Allergy Medications"
                        intent = new Intent(WhatTheSystemProvideActivity.this, AllergyMedications.class);
                        break;
                    case 4:   // "Allergy Awareness"
                        intent = new Intent(WhatTheSystemProvideActivity.this, AllergyAwarenessActivity.class);
                        break;
                    case 5: // "Your Profile"
                        if (ProfileAccess) {
                            intent = new Intent(WhatTheSystemProvideActivity.this, UserProfileActivity.class);
                            intent.putExtra("email", email); // Pass email to UserProfileActivity
                            startActivity(intent);

                        } else {
                            // Notify user they need to sign in
                            Toast.makeText(WhatTheSystemProvideActivity.this, "Please sign in to access your profile.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    default:
                        return;
                }
                startActivity(intent);
            }
        };
        // Initialize the ListView and bind the item click listener
        ListView listView = (ListView) findViewById(R.id.lstoptions);
        listView.setOnItemClickListener(itemClickListener);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}