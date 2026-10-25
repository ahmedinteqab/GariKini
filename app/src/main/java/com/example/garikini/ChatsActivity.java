package com.example.garikini;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ChatsActivity extends AppCompatActivity {

    private FloatingActionButton fabPost;
    private LinearLayout layoutEmptyState, layoutActiveChat;
    private TextView tvChatProductTitle;
    private Button btnOpenChatThread;

    // Bottom Navigation Containers
    private LinearLayout navHome, navSearch, navChats, navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        // 1. Initialize Views
        fabPost = findViewById(R.id.fabPost);
        layoutEmptyState = findViewById(R.id.layoutEmptyState);
        layoutActiveChat = findViewById(R.id.layoutActiveChat);
        tvChatProductTitle = findViewById(R.id.tvChatProductTitle);
        btnOpenChatThread = findViewById(R.id.btnOpenChatThread);

        // 2. Initialize Bottom Navigation Links
        navHome = findViewById(R.id.navHome);
        navSearch = findViewById(R.id.navSearch);
        navChats = findViewById(R.id.navChats);
        navProfile = findViewById(R.id.navProfile);

        // 3. Check if user came here by clicking "Contact Seller" on a product
        String productTitle = getIntent().getStringExtra("CHAT_PRODUCT_TITLE");
        if (productTitle != null && !productTitle.isEmpty()) {
            // Hide empty state, show active chat thread regarding this product
            layoutEmptyState.setVisibility(View.GONE);
            layoutActiveChat.setVisibility(View.VISIBLE);
            tvChatProductTitle.setText("Inquiry: " + productTitle);
        } else {
            // Show default empty state
            layoutEmptyState.setVisibility(View.VISIBLE);
            layoutActiveChat.setVisibility(View.GONE);
        }

        // 4. Action when tapping the active chat thread button
        btnOpenChatThread.setOnClickListener(v -> {
            Toast.makeText(this, "Opening live messaging thread...", Toast.LENGTH_SHORT).show();
        });

        // 5. Floating Action Button -> Opens Add Post Activity
        fabPost.setOnClickListener(v -> {
            Intent intent = new Intent(ChatsActivity.this, AddPostActivity.class);
            startActivity(intent);
        });

        // =========================================================================
        // 6. BOTTOM NAVIGATION BAR CLICK LISTENERS
        // =========================================================================

        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                Intent intent = new Intent(ChatsActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            });
        }

        if (navSearch != null) {
            navSearch.setOnClickListener(v -> {
                startActivity(new Intent(ChatsActivity.this, SearchActivity.class));
            });
        }

        if (navChats != null) {
            navChats.setOnClickListener(v -> {
                // Already on Chats screen
            });
        }

        if (navProfile != null) {
            navProfile.setOnClickListener(v -> {
                startActivity(new Intent(ChatsActivity.this, ProfileActivity.class));
            });
        }
    }
}