package com.example.garikini;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class LocationSelectorActivity extends AppCompatActivity {

    private Toolbar toolbarLocation;
    private CardView cardChattogram, cardRajshahi, cardKhulna, cardBarisal, cardSylhet, cardDhaka, cardRangpur, cardMymensingh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selector);

        // Initialize Toolbar with back navigation
        toolbarLocation = findViewById(R.id.toolbarLocation);
        setSupportActionBar(toolbarLocation);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("GariKini");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbarLocation.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Return to previous screen
            }
        });

        // Initialize Location Cards
        cardChattogram = findViewById(R.id.cardChattogram);
        cardRajshahi = findViewById(R.id.cardRajshahi);
        cardKhulna = findViewById(R.id.cardKhulna);
        cardBarisal = findViewById(R.id.cardBarisal);
        cardSylhet = findViewById(R.id.cardSylhet);
        cardDhaka = findViewById(R.id.cardDhaka);
        cardRangpur = findViewById(R.id.cardRangpur);
        cardMymensingh = findViewById(R.id.cardMymensingh);

        // Set click listeners for each division
        setupLocationClick(cardChattogram, "Chattogram");
        setupLocationClick(cardRajshahi, "Rajshahi");
        setupLocationClick(cardKhulna, "Khulna");
        setupLocationClick(cardBarisal, "Barisal");
        setupLocationClick(cardSylhet, "Sylhet");
        setupLocationClick(cardDhaka, "Dhaka");
        setupLocationClick(cardRangpur, "Rangpur");
        setupLocationClick(cardMymensingh, "Mymensingh");
    }

    private void setupLocationClick(CardView cardView, final String locationName) {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LocationSelectorActivity.this, "Selected: " + locationName, Toast.LENGTH_SHORT).show();

                // Pass the selected location back to Home or calling Activity
                Intent intent = new Intent();
                intent.putExtra("SELECTED_LOCATION", locationName);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}