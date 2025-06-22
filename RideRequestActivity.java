package com.example.rideshare;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RideRequestActivity extends AppCompatActivity {
    EditText etPickup, etDrop;
    Button btnSubmit;
    RideDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_request);

        etPickup = findViewById(R.id.etPickup);
        etDrop = findViewById(R.id.etDrop);
        btnSubmit = findViewById(R.id.btnSubmit);
        dbHelper = new RideDatabaseHelper(this);

        btnSubmit.setOnClickListener(v -> {
            String pickup = etPickup.getText().toString();
            String drop = etDrop.getText().toString();

            if (!pickup.isEmpty() && !drop.isEmpty()) {
                boolean inserted = dbHelper.insertRide(pickup, drop);
                if (inserted) {
                    Toast.makeText(this, "Ride Requested!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Failed to save ride.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
