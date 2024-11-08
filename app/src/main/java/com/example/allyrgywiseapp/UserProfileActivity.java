package com.example.allyrgywiseapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserProfileActivity extends AppCompatActivity {
    private Button btnlogout;
private TextView txtname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_profile);

// Initialize
        btnlogout = findViewById(R.id.btnlogout);
        btnlogout.setBackgroundColor(Color.parseColor("#e0ae77"));

        // Retrieve the user's email passed from the previous activity
        String email = getIntent().getStringExtra("email");
        txtname = findViewById(R.id.txtname);
        txtname.setText(email != null ? email : "Name");

        //Handle Logout button
        btnlogout.setOnClickListener(v -> {
            Intent intent = new Intent(UserProfileActivity.this, LogInActivity.class);
            startActivity(intent);
        });

        //set a ListView item click listener for profile options

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0: // "User Allergy Activity"
                        intent = new Intent(UserProfileActivity.this, YourAllergyActivity.class);
                        break;
                    case 1: // "User Medication Activity"
                        intent = new Intent(UserProfileActivity.this, YourMedicationActivity.class);
                        break;
                    case 2: // "Emergency Contact Activity"
                        intent = new Intent(UserProfileActivity.this, EmergencyContactActivity.class);
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            }
        };

        // Initialize ListView and binding the item click listener
        ListView listView = (ListView) findViewById(R.id.lstprofile);
        listView.setOnItemClickListener(itemClickListener);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
