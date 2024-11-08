package com.example.allyrgywiseapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class YourAllergyActivity extends AppCompatActivity {
    private EditText edtallergy;
    private Button btnadd;
    private ListView allergylist;
    private ArrayList<String> allergyNames; // List to store allergy names
    private ArrayAdapter<String> adapter; // Adapter to bind the list to the ListView

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_your_allergy);

// Initializes
        edtallergy = findViewById(R.id.editTextText);
        btnadd = findViewById(R.id.button);
        btnadd.setBackgroundColor(Color.parseColor("#e0ae77"));
        allergylist = findViewById(R.id.listView);

// Initializes arraylist & adapter
        allergyNames = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allergyNames);
        allergylist.setAdapter(adapter);

//handle add button
        btnadd.setOnClickListener(v -> {
            String allergy = edtallergy.getText().toString().trim();
            if (!allergy.isEmpty()) {
                //adding to list
                allergyNames.add(allergy);
                //Update the List
                adapter.notifyDataSetChanged();
                //clear input field
                edtallergy.setText("");
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
