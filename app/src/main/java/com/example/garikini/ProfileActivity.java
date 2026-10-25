package com.example.garikini;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {

    private Toolbar toolbarProfile;
    private FloatingActionButton fabPost;
    private CardView cardLogout;

    // Bottom Navigation Containers
    private LinearLayout navHome, navSearch, navChats, navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // 1. Initialize Toolbar
        toolbarProfile = findViewById(R.id.toolbarProfile);
        setSupportActionBar(toolbarProfile);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Profile");
        }

        // 2. Initialize Views & Floating Action Button
        fabPost = findViewById(R.id.fabPost);
        cardLogout = findViewById(R.id.cardLogout);

        // 3. Initialize Bottom Navigation Links
        navHome = findViewById(R.id.navHome);
        navSearch = findViewById(R.id.navSearch);
        navChats = findViewById(R.id.navChats);
        navProfile = findViewById(R.id.navProfile);

        // 4. Floating Action Button -> Opens Add Post Activity
        fabPost.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, AddPostActivity.class);
            startActivity(intent);
        });

        // 5. Logout Action
        if (cardLogout != null) {
            cardLogout.setOnClickListener(v -> {
                Toast.makeText(ProfileActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            });
        }

        // =========================================================================
        // 6. BOTTOM NAVIGATION BAR CLICK LISTENERS
        // =========================================================================

        // Home Tab -> Navigates back to HomeActivity
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            });
        }

        // Search Tab -> Navigates to SearchActivity
        if (navSearch != null) {
            navSearch.setOnClickListener(v -> {
                Intent intent = new Intent(ProfileActivity.this, SearchActivity.class);
                startActivity(intent);
            });
        }

        // Chats Tab -> Navigates to ChatsActivity
        if (navChats != null) {
            navChats.setOnClickListener(v -> {
                Intent intent = new Intent(ProfileActivity.this, ChatsActivity.class);
                startActivity(intent);
            });
        }

        // Profile Tab (Already here, do nothing or refresh)
        if (navProfile != null) {
            navProfile.setOnClickListener(v -> {
                // Already on Profile screen
            });
        }
    }
}