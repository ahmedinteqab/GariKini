package com.example.garikini;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BimanTicketActivity extends AppCompatActivity {

    private EditText etFromCity, etToCity, etDepartureDate, etPassengers;
    private Spinner spinnerFlightClass;
    private Button btnSearchFlights;

    // Bottom Navigation Elements (Optional click handling)
    private View navHome, navSearch, fabPost, navChats, navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biman_ticket);

        // Initialize Form Views
        etFromCity = findViewById(R.id.etFromCity);
        etToCity = findViewById(R.id.etToCity);
        etDepartureDate = findViewById(R.id.etDepartureDate);
        etPassengers = findViewById(R.id.etPassengers);
        spinnerFlightClass = findViewById(R.id.spinnerFlightClass);
        btnSearchFlights = findViewById(R.id.btnSearchFlights);

        // Populate Flight Classes in Spinner
        String[] flightClasses = {"Economy Class", "Business Class", "First Class"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                flightClasses
        );
        spinnerFlightClass.setAdapter(adapter);

        // Setup Date Picker Dialog for Departure Date
        etDepartureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Handle Search Flight Action
        btnSearchFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchFlights();
            }
        });

        // Setup Bottom Navigation Click Listeners
        setupBottomNavigation();
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String formattedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    etDepartureDate.setText(formattedDate);
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    private void searchFlights() {
        String from = etFromCity.getText().toString().trim();
        String to = etToCity.getText().toString().trim();
        String date = etDepartureDate.getText().toString().trim();

        if (from.isEmpty() || to.isEmpty() || date.isEmpty()) {
            Toast.makeText(this, "Please fill in origin, destination, and date", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Searching Biman E-Tickets...", Toast.LENGTH_SHORT).show();
        // TODO: Implement search results trigger or API call here
    }

    private void setupBottomNavigation() {
        // Find bottom navigation layout sections if you want interactive navigation
        findViewById(R.id.bottomNavigationContainer).setOnClickListener(v -> {});

        // If you'd like to wire individual bottom bar tabs to switch activities, you can map them here:
        // Example: Home tab navigation back to HomeActivity
    }
}