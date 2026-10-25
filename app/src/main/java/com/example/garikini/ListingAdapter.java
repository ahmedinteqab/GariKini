package com.example.garikini;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListingAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> titles;
    private ArrayList<String> prices;
    private ArrayList<String> imageUris;

    public ListingAdapter(Context context, ArrayList<String> titles, ArrayList<String> prices, ArrayList<String> imageUris) {
        this.context = context;
        this.titles = titles;
        this.prices = prices;
        this.imageUris = imageUris;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listing, parent, false);
        }

        ImageView ivItemImage = convertView.findViewById(R.id.ivItemImage);
        TextView tvItemTitle = convertView.findViewById(R.id.tvItemTitle);
        TextView tvItemPrice = convertView.findViewById(R.id.tvItemPrice);

        // Set text values
        tvItemTitle.setText(titles.get(position));
        tvItemPrice.setText(prices.get(position));

        // Load image URI or fallback to default gallery icon
        String uriStr = imageUris.get(position);
        if (uriStr != null && !uriStr.isEmpty()) {
            ivItemImage.setImageURI(Uri.parse(uriStr));
            ivItemImage.setImageTintList(null); // Clears any color filter/tint so the photo appears in full color
        } else {
            ivItemImage.setImageResource(android.R.drawable.ic_menu_gallery);
            ivItemImage.setImageTintList(null);
        }

        return convertView;
    }
}