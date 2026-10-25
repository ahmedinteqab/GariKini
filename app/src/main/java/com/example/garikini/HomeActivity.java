package com.example.garikini;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout layoutLocation, layoutCategory, layoutBimanTicket;
    private GridView gvListings;
    private FloatingActionButton fabPost;
    private LinearLayout navHome, navSearch, navChats, navProfile;

    // Master lists containing all posts
    private ArrayList<String> masterTitlesList;
    private ArrayList<String> masterPricesList;
    private ArrayList<String> masterImageUrisList;
    private ArrayList<String> masterImageUris2List;
    private ArrayList<String> masterBrandsList;
    private ArrayList<String> masterYearsList;
    private ArrayList<String> masterConditionsList;
    private ArrayList<String> masterLocationsList;
    private ArrayList<String> masterDescriptionsList;
    private ArrayList<String> masterContactsList;

    // Display lists currently shown on screen (filtered or unfiltered)
    private ArrayList<String> displayTitlesList;
    private ArrayList<String> displayPricesList;
    private ArrayList<String> displayImageUrisList;
    private ArrayList<String> displayImageUris2List;
    private ArrayList<String> displayBrandsList;
    private ArrayList<String> displayYearsList;
    private ArrayList<String> displayConditionsList;
    private ArrayList<String> displayLocationsList;
    private ArrayList<String> displayDescriptionsList;
    private ArrayList<String> displayContactsList;

    private ListingAdapter listingAdapter;
    private static final int ADD_POST_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        layoutLocation = findViewById(R.id.layoutLocation);
        layoutCategory = findViewById(R.id.layoutCategory);
        layoutBimanTicket = findViewById(R.id.layoutBimanTicket);
        gvListings = findViewById(R.id.gvListings);
        fabPost = findViewById(R.id.fabPost);

        navHome = findViewById(R.id.navHome);
        navSearch = findViewById(R.id.navSearch);
        navChats = findViewById(R.id.navChats);
        navProfile = findViewById(R.id.navProfile);

        // 1. Drawable Image URIs for your 8 Dummy Posts
        // (Make sure you have added car1, truck, civic, pajero, bus, bike, swift, and premio into your res/drawable folder)
        String img1 = "android.resource://com.example.garikini/drawable/crown";
        String img2 = "android.resource://com.example.garikini/drawable/truck";
        String img3 = "android.resource://com.example.garikini/drawable/images";
        String img4 = "android.resource://com.example.garikini/drawable/pajaru";
        String img5 = "android.resource://com.example.garikini/drawable/bus";
        String img6 = "android.resource://com.example.garikini/drawable/bike";
        String img7 = "android.resource://com.example.garikini/drawable/swift";
        String img8 = "android.resource://com.example.garikini/drawable/primio";

        // 2. Initialize Master Lists with 8 Dummy Posts
        masterTitlesList = new ArrayList<>(Arrays.asList(
                "Toyota Crown Wxb",
                "Hino Heavy Truck",
                "Honda Civic Hybrid",
                "Mitsubishi Pajero",
                "Tata Intercity Bus",
                "Yamaha FZS Fi V3",
                "Suzuki Swift GL",
                "Toyota Premio F"
        ));

        masterPricesList = new ArrayList<>(Arrays.asList(
                "৳ 30,00,000",
                "৳ 35,50,000",
                "৳ 28,00,000",
                "৳ 65,00,000",
                "৳ 85,00,000",
                "৳ 2,45,000",
                "৳ 14,50,000",
                "৳ 24,00,000"
        ));

        masterImageUrisList = new ArrayList<>(Arrays.asList(img1, img2, img3, img4, img5, img6, img7, img8));
        masterImageUris2List = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", ""));

        masterBrandsList = new ArrayList<>(Arrays.asList(
                "Toyota Crown WxB",
                "Hino 500 Series",
                "Honda Civic",
                "Mitsubishi Pajero Sport",
                "Tata Starbus",
                "Yamaha FZS",
                "Suzuki Swift",
                "Toyota Premio"
        ));

        masterYearsList = new ArrayList<>(Arrays.asList("2020", "2019", "2021", "2022", "2018", "2023", "2019", "2020"));

        masterConditionsList = new ArrayList<>(Arrays.asList(
                "Reconditioned",
                "Used",
                "Reconditioned",
                "Brand New",
                "Used",
                "Brand New",
                "Reconditioned",
                "Reconditioned"
        ));

        masterLocationsList = new ArrayList<>(Arrays.asList(
                "Dhaka, Gulshan",
                "Chattogram, Pahartali",
                "Sylhet, Sadar",
                "Dhaka, Banani",
                "Chattogram, Kotwali",
                "Khulna, Sonadanga",
                "Rajshahi, Boalia",
                "Sylhet, Zindabazar"
        ));

        masterDescriptionsList = new ArrayList<>(Arrays.asList(
                "Super fresh condition, push start, leather seats, octane driven.",
                "Heavy duty commercial cargo truck, well maintained engine.",
                "Excellent fuel efficiency, hybrid system, pearl white color.",
                "4x4 full option luxury SUV, sunroof, immaculate condition.",
                "32-seater commercial passenger bus, AC operational.",
                "Like new condition, single owner, all papers up to date.",
                "Compact city hatchback, smooth automatic transmission.",
                "Executive sedan, elegant pearl finish, low mileage."
        ));

        masterContactsList = new ArrayList<>(Arrays.asList(
                "01711111111",
                "01822222222",
                "01933333333",
                "01644444444",
                "01555555555",
                "01366666666",
                "01777777777",
                "01888888888"
        ));

        // 3. Copy master items to display items initially
        displayTitlesList = new ArrayList<>(masterTitlesList);
        displayPricesList = new ArrayList<>(masterPricesList);
        displayImageUrisList = new ArrayList<>(masterImageUrisList);
        displayImageUris2List = new ArrayList<>(masterImageUris2List);
        displayBrandsList = new ArrayList<>(masterBrandsList);
        displayYearsList = new ArrayList<>(masterYearsList);
        displayConditionsList = new ArrayList<>(masterConditionsList);
        displayLocationsList = new ArrayList<>(masterLocationsList);
        displayDescriptionsList = new ArrayList<>(masterDescriptionsList);
        displayContactsList = new ArrayList<>(masterContactsList);

        // 4. Set Custom Adapter with display lists
        listingAdapter = new ListingAdapter(this, displayTitlesList, displayPricesList, displayImageUrisList);
        gvListings.setAdapter(listingAdapter);

        // 5. Grid Item Click -> Open PostDetailsActivity with full data mapping
        gvListings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, PostDetailsActivity.class);
                intent.putExtra("DETAIL_TITLE", displayTitlesList.get(position));
                intent.putExtra("DETAIL_PRICE", displayPricesList.get(position));
                intent.putExtra("DETAIL_IMAGE_URI_1", displayImageUrisList.get(position));
                intent.putExtra("DETAIL_IMAGE_URI_2", displayImageUris2List.get(position));
                intent.putExtra("DETAIL_BRAND", displayBrandsList.get(position));
                intent.putExtra("DETAIL_YEAR", displayYearsList.get(position));
                intent.putExtra("DETAIL_CONDITION", displayConditionsList.get(position));
                intent.putExtra("DETAIL_LOCATION", displayLocationsList.get(position));
                intent.putExtra("DETAIL_DESCRIPTION", displayDescriptionsList.get(position));
                intent.putExtra("DETAIL_CONTACT", displayContactsList.get(position));

                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(intent);
            }
        });

        // 6. Top Quick Actions Clicks
        layoutLocation.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, LocationSelectorActivity.class)));
        layoutCategory.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, CategoryActivity.class)));
        layoutBimanTicket.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, BimanTicketActivity.class)));

        // 7. Floating Action Button -> Open Add Post Screen
        fabPost.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AddPostActivity.class);
            startActivityForResult(intent, ADD_POST_REQUEST_CODE);
        });

        // 8. Bottom Navigation Clicks
        if (navHome != null) navHome.setOnClickListener(v -> filterListingsByLocation("All"));
        if (navSearch != null) navSearch.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, SearchActivity.class)));
        if (navChats != null) navChats.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, ChatsActivity.class)));
        if (navProfile != null) navProfile.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, ProfileActivity.class)));
    }

    private void filterListingsByLocation(String locationQuery) {
        displayTitlesList.clear();
        displayPricesList.clear();
        displayImageUrisList.clear();
        displayImageUris2List.clear();
        displayBrandsList.clear();
        displayYearsList.clear();
        displayConditionsList.clear();
        displayLocationsList.clear();
        displayDescriptionsList.clear();
        displayContactsList.clear();

        for (int i = 0; i < masterLocationsList.size(); i++) {
            String loc = masterLocationsList.get(i);
            if (locationQuery.equals("All") || loc.toLowerCase().contains(locationQuery.toLowerCase())) {
                displayTitlesList.add(masterTitlesList.get(i));
                displayPricesList.add(masterPricesList.get(i));
                displayImageUrisList.add(masterImageUrisList.get(i));
                displayImageUris2List.add(masterImageUris2List.get(i));
                displayBrandsList.add(masterBrandsList.get(i));
                displayYearsList.add(masterYearsList.get(i));
                displayConditionsList.add(masterConditionsList.get(i));
                displayLocationsList.add(masterLocationsList.get(i));
                displayDescriptionsList.add(masterDescriptionsList.get(i));
                displayContactsList.add(masterContactsList.get(i));
            }
        }

        listingAdapter.notifyDataSetChanged();
    }

    // Receive newly added posts and store them in master lists instantly
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_POST_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("NEW_TITLE");
            String price = data.getStringExtra("NEW_PRICE");
            String brand = data.getStringExtra("NEW_BRAND");
            String year = data.getStringExtra("NEW_YEAR");
            String condition = data.getStringExtra("NEW_CONDITION");
            String district = data.getStringExtra("NEW_DISTRICT");
            String upazila = data.getStringExtra("NEW_UPAZILA");
            String description = data.getStringExtra("NEW_DESCRIPTION");
            String contact = data.getStringExtra("NEW_CONTACT");
            String img1 = data.getStringExtra("NEW_IMAGE_URI_1");
            String img2 = data.getStringExtra("NEW_IMAGE_URI_2");

            if (title != null && price != null) {
                String fullLocation = (district != null ? district : "") + ", " + (upazila != null ? upazila : "");

                masterTitlesList.add(0, title);
                masterPricesList.add(0, price);
                masterImageUrisList.add(0, img1 != null ? img1 : "");
                masterImageUris2List.add(0, img2 != null ? img2 : "");
                masterBrandsList.add(0, brand != null ? brand : "N/A");
                masterYearsList.add(0, year != null ? year : "N/A");
                masterConditionsList.add(0, condition != null ? condition : "N/A");
                masterLocationsList.add(0, fullLocation);
                masterDescriptionsList.add(0, description != null && !description.isEmpty() ? description : "No additional description.");
                masterContactsList.add(0, contact != null ? contact : "N/A");

                displayTitlesList.clear();
                displayTitlesList.addAll(masterTitlesList);
                displayPricesList.clear();
                displayPricesList.addAll(masterPricesList);
                displayImageUrisList.clear();
                displayImageUrisList.addAll(masterImageUrisList);
                displayImageUris2List.clear();
                displayImageUris2List.addAll(masterImageUris2List);
                displayBrandsList.clear();
                displayBrandsList.addAll(masterBrandsList);
                displayYearsList.clear();
                displayYearsList.addAll(masterYearsList);
                displayConditionsList.clear();
                displayConditionsList.addAll(masterConditionsList);
                displayLocationsList.clear();
                displayLocationsList.addAll(masterLocationsList);
                displayDescriptionsList.clear();
                displayDescriptionsList.addAll(masterDescriptionsList);
                displayContactsList.clear();
                displayContactsList.addAll(masterContactsList);

                listingAdapter.notifyDataSetChanged();
                Toast.makeText(this, "New Listing Added to Feed!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}