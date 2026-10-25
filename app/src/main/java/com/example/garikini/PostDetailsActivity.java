package com.example.garikini;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PostDetailsActivity extends AppCompatActivity {

    private Toolbar toolbarDetails;
    private ImageView ivDetailImage1, ivDetailImage2;
    private TextView tvDetailTitle, tvDetailPrice, tvDetailBrand, tvDetailYear, tvDetailCondition, tvDetailLocation, tvDetailDescription;
    private Button btnContactSeller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        toolbarDetails = findViewById(R.id.toolbarDetails);
        setSupportActionBar(toolbarDetails);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Listing Details");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbarDetails.setNavigationOnClickListener(v -> finish());

        ivDetailImage1 = findViewById(R.id.ivDetailImage1);
        ivDetailImage2 = findViewById(R.id.ivDetailImage2);
        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        tvDetailPrice = findViewById(R.id.tvDetailPrice);
        tvDetailBrand = findViewById(R.id.tvDetailBrand);
        tvDetailYear = findViewById(R.id.tvDetailYear);
        tvDetailCondition = findViewById(R.id.tvDetailCondition);
        tvDetailLocation = findViewById(R.id.tvDetailLocation);
        tvDetailDescription = findViewById(R.id.tvDetailDescription);
        btnContactSeller = findViewById(R.id.btnContactSeller);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("DETAIL_TITLE");
            String price = intent.getStringExtra("DETAIL_PRICE");
            String brand = intent.getStringExtra("DETAIL_BRAND");
            String year = intent.getStringExtra("DETAIL_YEAR");
            String condition = intent.getStringExtra("DETAIL_CONDITION");
            String location = intent.getStringExtra("DETAIL_LOCATION");
            String description = intent.getStringExtra("DETAIL_DESCRIPTION");
            String contact = intent.getStringExtra("DETAIL_CONTACT");
            String imgUriStr1 = intent.getStringExtra("DETAIL_IMAGE_URI_1");
            String imgUriStr2 = intent.getStringExtra("DETAIL_IMAGE_URI_2");

            if (title != null) tvDetailTitle.setText(title);
            if (price != null) tvDetailPrice.setText(price);
            if (brand != null) tvDetailBrand.setText("Brand & Model: " + brand);
            if (year != null) tvDetailYear.setText("Manufacture Year: " + year);
            if (condition != null) tvDetailCondition.setText("Condition: " + condition);
            if (location != null) tvDetailLocation.setText("Location: " + location);
            if (description != null) tvDetailDescription.setText(description);

            // Load Image 1
            if (imgUriStr1 != null && !imgUriStr1.isEmpty()) {
                try {
                    Uri uri1 = Uri.parse(imgUriStr1);
                    try {
                        getContentResolver().takePersistableUriPermission(uri1, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    } catch (Exception ignored) {}
                    ivDetailImage1.setImageURI(uri1);
                    ivDetailImage1.setImageTintList(null);
                } catch (Exception e) {
                    ivDetailImage1.setImageResource(android.R.drawable.ic_menu_gallery);
                    ivDetailImage1.setImageTintList(null);
                }
            } else {
                ivDetailImage1.setImageResource(android.R.drawable.ic_menu_gallery);
                ivDetailImage1.setImageTintList(null);
            }

            // Load Image 2 (if provided)
            if (imgUriStr2 != null && !imgUriStr2.isEmpty()) {
                try {
                    Uri uri2 = Uri.parse(imgUriStr2);
                    try {
                        getContentResolver().takePersistableUriPermission(uri2, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    } catch (Exception ignored) {}
                    ivDetailImage2.setVisibility(View.VISIBLE);
                    ivDetailImage2.setImageURI(uri2);
                    ivDetailImage2.setImageTintList(null);
                } catch (Exception e) {
                    ivDetailImage2.setVisibility(View.GONE);
                }
            } else {
                ivDetailImage2.setVisibility(View.GONE);
            }

            btnContactSeller.setOnClickListener(v -> {
                Toast.makeText(this, "Calling/Messaging seller at: " + contact, Toast.LENGTH_LONG).show();
                Intent chatIntent = new Intent(PostDetailsActivity.this, ChatsActivity.class);
                chatIntent.putExtra("CHAT_PRODUCT_TITLE", title);
                startActivity(chatIntent);
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}