package com.example.allyrgywiseapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
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

public class YourMedicationActivity extends AppCompatActivity {

    private EditText edtmedication;
    private Button btnadd;
    private ListView medicationlist;
    private ArrayList<String> allergymedication; // List to store allergy names
    private ArrayAdapter<String> adapterallergymedication; // Adapter to bind the list to the ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_your_medication);

            // Initialize
            edtmedication = findViewById(R.id.edtmedicationname);
            btnadd = findViewById(R.id.btnadd);
            btnadd.setBackgroundColor(Color.parseColor("#e0ae77"));
            medicationlist = findViewById(R.id.medicationlist);


        // Initialize list and adapter
        allergymedication = new ArrayList<>();
        adapterallergymedication = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allergymedication);
        medicationlist.setAdapter(adapterallergymedication);

//handle add button
            btnadd.setOnClickListener(v -> {
                String allergy = edtmedication.getText().toString().trim();
                if (!allergy.isEmpty()) {
                    //adding to list
                    allergymedication.add(allergy);
                    //update the list
                    adapterallergymedication.notifyDataSetChanged();
                    //clear
                    edtmedication.setText("");
                }
            });


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}