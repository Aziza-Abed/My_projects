package com.example.allyrgywiseapp;

import static com.example.allyrgywiseapp.R.id.spnallergy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class TypesOfAllergiesActivity extends AppCompatActivity {
    private Spinner spnallergy;
    private ListView lstofExamples;
    private TextView txttypename;
    private TextView txttypedescription;
    private ImageView imageView ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_types_of_allergies);

        // Initializes
        spnallergy = findViewById(R.id.spnallergy);
        lstofExamples = findViewById(R.id.lstofExamples);
        txttypename = findViewById(R.id.txttypename);
        txttypedescription = findViewById(R.id.txttypedescription);
        imageView = findViewById(R.id.imgtype);


        // Binds allergy types to the spinner
        bindSpinner();

        //handle & setting listener for the spinner selection
        spnallergy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Get the selected allergy type
                String selectedAllergyType = spnallergy.getSelectedItem().toString();

                // Initialize the allergy mock data and getting the data needed
                AllergyMockupData allergyData = new AllergyMockupData();
                txttypename.setText(selectedAllergyType);
                String description = allergyData.getDescriptionByType(selectedAllergyType);
                txttypedescription.setText(allergyData.getDescriptionByType(selectedAllergyType));
                int imageID = allergyData.getImageIDByType(selectedAllergyType);
                imageView.setImageResource(imageID);

                // Filling the examples list
                List<AllergyMockupData> examples = allergyData.getAllergyByType(selectedAllergyType);
                ArrayAdapter<AllergyMockupData> adapter = new ArrayAdapter<>(TypesOfAllergiesActivity.this,
                        android.R.layout.simple_list_item_1, examples);
                lstofExamples.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle cases where no item is selected if needed
            }
        });

        // Set up item click listener for ListView items
        lstofExamples.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected allergy example
                AllergyMockupData selectedExample = (AllergyMockupData) parent.getItemAtPosition(position);

                //  intent to open ImageExampleActivity
                Intent intent = new Intent(TypesOfAllergiesActivity.this, ImageExampleActivity.class);

                // Pass the allergy name and image ID to the new activity
                intent.putExtra("allergyName", selectedExample.toString()); // Uses toString to get AllergyName or TypeName
                intent.putExtra("imageID", selectedExample.getImageID());

                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method to bind allergy types to the spinner
    private void bindSpinner() {
        AllergyMockupData da = new AllergyMockupData();
        String[] arr = da.getAllergyTypes();
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);
        spnallergy.setAdapter(spnAdapter);
    }
}
