package com.example.garikini;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddPostActivity extends AppCompatActivity {

    private Toolbar toolbarAddPost;
    private Spinner spinnerDistrict, spinnerUpazila, spinnerCondition;
    private EditText etTitle, etPrice, etBrandModel, etYear, etDescription, etContact;
    private Button btnSubmitPost;
    private ImageView ivImage1, ivImage2;

    private Uri selectedImageUri1 = null;
    private Uri selectedImageUri2 = null;

    private static final int PICK_IMAGE_1 = 101;
    private static final int PICK_IMAGE_2 = 102;

    private String[] districtsList = {"Select District", "Chattogram", "Dhaka", "Sylhet", "Rajshahi", "Khulna"};
    private String[] upazilasList = {"Select Upazila", "Sadar", "Pahartali", "Kotwali", "Chandgaon"};
    private String[] conditionsList = {"Vehicle Condition", "Brand New", "Reconditioned", "Used"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        toolbarAddPost = findViewById(R.id.toolbarAddPost);
        setSupportActionBar(toolbarAddPost);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Add Post");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbarAddPost.setNavigationOnClickListener(v -> finish());

        spinnerDistrict = findViewById(R.id.spinnerDistrict);
        spinnerUpazila = findViewById(R.id.spinnerUpazila);
        spinnerCondition = findViewById(R.id.spinnerCondition);
        etTitle = findViewById(R.id.etTitle);
        etPrice = findViewById(R.id.etPrice);
        etBrandModel = findViewById(R.id.etBrandModel);
        etYear = findViewById(R.id.etYear);
        etDescription = findViewById(R.id.etDescription);
        etContact = findViewById(R.id.etContact);
        btnSubmitPost = findViewById(R.id.btnSubmitPost);
        ivImage1 = findViewById(R.id.ivImage1);
        ivImage2 = findViewById(R.id.ivImage2);

        spinnerDistrict.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, districtsList));
        spinnerUpazila.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, upazilasList));
        spinnerCondition.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, conditionsList));

        ivImage1.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_IMAGE_1);
        });

        ivImage2.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_IMAGE_2);
        });

        btnSubmitPost.setOnClickListener(v -> validateAndSubmitPost());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            if (requestCode == PICK_IMAGE_1) {
                selectedImageUri1 = imageUri;
                ivImage1.setImageURI(imageUri);
                ivImage1.setImageTintList(null);
                Toast.makeText(this, "Image 1 Selected", Toast.LENGTH_SHORT).show();
            } else if (requestCode == PICK_IMAGE_2) {
                selectedImageUri2 = imageUri;
                ivImage2.setImageURI(imageUri);
                ivImage2.setImageTintList(null);
                Toast.makeText(this, "Image 2 Selected", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void validateAndSubmitPost() {
        String title = etTitle.getText().toString().trim();
        String price = etPrice.getText().toString().trim();
        String brandModel = etBrandModel.getText().toString().trim();
        String year = etYear.getText().toString().trim();
        String description = etDescription.getText().toString().trim();
        String contact = etContact.getText().toString().trim();
        String district = spinnerDistrict.getSelectedItem().toString();
        String upazila = spinnerUpazila.getSelectedItem().toString();
        String condition = spinnerCondition.getSelectedItem().toString();

        if (district.equals("Select District")) {
            Toast.makeText(this, "Please select a district", Toast.LENGTH_SHORT).show();
            return;
        }
        if (title.isEmpty()) {
            etTitle.setError("Title is required");
            return;
        }
        if (price.isEmpty()) {
            etPrice.setError("Price is required");
            return;
        }
        if (condition.equals("Vehicle Condition")) {
            Toast.makeText(this, "Please select vehicle condition", Toast.LENGTH_SHORT).show();
            return;
        }
        if (contact.isEmpty()) {
            etContact.setError("Contact number is required");
            return;
        }

        // Send all details back to HomeActivity
        Intent resultIntent = new Intent();
        resultIntent.putExtra("NEW_TITLE", title);
        resultIntent.putExtra("NEW_PRICE", "৳ " + price);
        resultIntent.putExtra("NEW_BRAND", brandModel);
        resultIntent.putExtra("NEW_YEAR", year);
        resultIntent.putExtra("NEW_CONDITION", condition);
        resultIntent.putExtra("NEW_DISTRICT", district);
        resultIntent.putExtra("NEW_UPAZILA", upazila);
        resultIntent.putExtra("NEW_DESCRIPTION", description);
        resultIntent.putExtra("NEW_CONTACT", contact);

        if (selectedImageUri1 != null) {
            resultIntent.putExtra("NEW_IMAGE_URI_1", selectedImageUri1.toString());
        }
        if (selectedImageUri2 != null) {
            resultIntent.putExtra("NEW_IMAGE_URI_2", selectedImageUri2.toString());
        }

        setResult(RESULT_OK, resultIntent);
        Toast.makeText(this, "Listing Added Successfully!", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}