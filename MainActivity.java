package com.example.rideshare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button requestRideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        requestRideButton = findViewById(R.id.btnRequestRide);
        
        requestRideButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RideRequestActivity.class);
            startActivity(intent);
        });
    }
}
