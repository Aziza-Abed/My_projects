package com.example.allyrgywiseapp;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class EmergencyContactActivity extends AppCompatActivity {
    private Button btncontactadd;
    private EditText edtcontactname, edtnumber;
    private ListView contactList;
    private ArrayList<String> contactArray;
    private ArrayAdapter<String> contactArrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_emergency_contact);
// Initializes
        btncontactadd = findViewById(R.id.btncontactadd);
        btncontactadd.setBackgroundColor(Color.parseColor("#e0ae77"));
        edtcontactname = findViewById(R.id.edtcontactname);
        edtnumber = findViewById(R.id.edtnumber);
        contactList = findViewById(R.id.contactlist);


// Initializes ArrayList and an ArrayAdapter to manage ListView display
        contactArray = new ArrayList<>();
        contactArrayadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactArray);
        contactList.setAdapter(contactArrayadapter);

//handle adding contacts
        btncontactadd.setOnClickListener(view -> {
            String name = edtcontactname.getText().toString().trim();
            String phone = edtnumber.getText().toString().trim();

            if (!name.isEmpty() && !phone.isEmpty()) {
                //add to array list
                contactArray.add(name + "  :  " + phone);
                contactArrayadapter.notifyDataSetChanged();
                //clear input field
                edtcontactname.setText("");
                edtnumber.setText("");
                Toast.makeText(this, "Contact added!", Toast.LENGTH_SHORT).show();

            } else {
                //warning  for empty field
                Toast.makeText(this, "Please Enter both Name and Phone Number.", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
