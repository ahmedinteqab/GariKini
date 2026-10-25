package com.example.garikini;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CategoryActivity extends AppCompatActivity {

    private Toolbar toolbarCategory;
    private ListView lvCategories; // Fixed: changed from GridView to ListView

    // Full list of categories
    private String[] categoriesList = {
            "All Ads",
            "Top Urgent",
            "Light Vehicles",
            "Heavy Vehicles",
            "Heavy & Equipment Vehicles",
            "Motorbike",
            "Bicycle",
            "Auto CNG",
            "Paddle Rickshaw",
            "Paddle Van",
            "Three Wheeler",
            "Auto Service Center",
            "Auto Spare Shop",
            "Auto Spare Parts",
            "Garage",
            "Parking",
            "Rental Vehicle",
            "Water Transport",
            "Agro Vehicle",
            "Want to Buy",
            "Helicopter"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Initialize Toolbar
        toolbarCategory = findViewById(R.id.toolbarCategory);
        setSupportActionBar(toolbarCategory);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("GariKini");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbarCategory.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Fixed: matches android:id="@+id/lvCategories" in activity_category.xml
        lvCategories = findViewById(R.id.lvCategories);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                categoriesList
        );
        lvCategories.setAdapter(adapter);

        // Handle Item Selection Clicks
        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categoriesList[position];
                Toast.makeText(CategoryActivity.this, "Selected: " + selectedCategory, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.putExtra("SELECTED_CATEGORY", selectedCategory);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}