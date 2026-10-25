package com.example.garikini;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SearchActivity extends AppCompatActivity {

    private Toolbar toolbarSearch;
    private EditText etSearchKeyword;
    private Spinner spinnerSearchCategory, spinnerSearchLocation;
    private Button btnPerformSearch;
    private FloatingActionButton fabPost;

    // Bottom Navigation Containers
    private LinearLayout navHome, navSearch, navChats, navProfile;

    private String[] categoriesList = {"All Categories", "Light Vehicles", "Heavy Vehicles", "Bus", "Truck", "Motorbike", "Bicycle"};
    private String[] locationsList = {"All Bangladesh", "Chattogram", "Dhaka", "Rajshahi", "Khulna", "Barisal", "Sylhet"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // 1. Initialize Toolbar
        toolbarSearch = findViewById(R.id.toolbarSearch);
        setSupportActionBar(toolbarSearch);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Search Listings");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbarSearch.setNavigationOnClickListener(v -> finish());

        // 2. Initialize Views
        etSearchKeyword = findViewById(R.id.etSearchKeyword);
        spinnerSearchCategory = findViewById(R.id.spinnerSearchCategory);
        spinnerSearchLocation = findViewById(R.id.spinnerSearchLocation);
        btnPerformSearch = findViewById(R.id.btnPerformSearch);
        fabPost = findViewById(R.id.fabPost);

        // 3. Initialize Bottom Navigation Links
        navHome = findViewById(R.id.navHome);
        navSearch = findViewById(R.id.navSearch);
        navChats = findViewById(R.id.navChats);
        navProfile = findViewById(R.id.navProfile);

        // 4. Populate Spinners
        spinnerSearchCategory.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categoriesList));
        spinnerSearchLocation.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locationsList));

        // 5. Perform Search Logic (Keyword + Category + Location)
        btnPerformSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = etSearchKeyword.getText().toString().trim();
                String selectedCategory = spinnerSearchCategory.getSelectedItem().toString();
                String selectedLocation = spinnerSearchLocation.getSelectedItem().toString();

                // Validate if user provided at least something or wants a broad filter
                StringBuilder searchSummary = new StringBuilder("Searching for: ");

                if (!keyword.isEmpty()) {
                    searchSummary.append("'").append(keyword).append("' ");
                } else {
                    searchSummary.append("'").append(selectedCategory).append("' ");
                }
                searchSummary.append("in ").append(selectedLocation);

                Toast.makeText(SearchActivity.this, searchSummary.toString(), Toast.LENGTH_LONG).show();

                // OPTIONALLY: If you want to return the search query back to HomeActivity feed:
                Intent resultIntent = new Intent();
                resultIntent.putExtra("SEARCH_KEYWORD", keyword);
                resultIntent.putExtra("SEARCH_CATEGORY", selectedCategory);
                resultIntent.putExtra("SEARCH_LOCATION", selectedLocation);
                setResult(RESULT_OK, resultIntent);

                // If you want it to jump back to Home with results filtered:
                // finish();
            }
        });

        // 6. Floating Action Button -> Open Add Post Activity
        fabPost.setOnClickListener(v -> {
            Intent intent = new Intent(SearchActivity.this, AddPostActivity.class);
            startActivity(intent);
        });

        // =========================================================================
        // 7. BOTTOM NAVIGATION BAR CLICK LISTENERS
        // =========================================================================

        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                Intent intent = new Intent(SearchActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            });
        }

        if (navSearch != null) {
            navSearch.setOnClickListener(v -> {
                // Already on Search screen
            });
        }

        if (navChats != null) {
            navChats.setOnClickListener(v -> {
                startActivity(new Intent(SearchActivity.this, ChatsActivity.class));
            });
        }

        if (navProfile != null) {
            navProfile.setOnClickListener(v -> {
                startActivity(new Intent(SearchActivity.this, ProfileActivity.class));
            });
        }
    }
}