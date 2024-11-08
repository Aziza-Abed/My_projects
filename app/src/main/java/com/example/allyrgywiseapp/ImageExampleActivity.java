package com.example.allyrgywiseapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//this class is used to display Allergy Related info for the user
public class ImageExampleActivity extends AppCompatActivity {
private TextView txtexamplename;
private TextView txtexampleinfo;
private ImageView imgexample;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_example);

        //initialize
        txtexamplename = findViewById(R.id.txtexamplename);
        txtexampleinfo = findViewById(R.id.txtexampleinfo);
        imgexample = findViewById(R.id.imgexample);

        // get and set the suitable data for each list item
        AllergyMockupData allergyData = new AllergyMockupData();
        String allergyName = getIntent().getStringExtra("allergyName");
        int imageID = getIntent().getIntExtra("imageID", 0);
        String allergyInfo = allergyData.getInfoByName(allergyName);

        txtexamplename.setText(allergyName);
        txtexampleinfo.setText(allergyInfo);
        imgexample.setImageResource(imageID);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}