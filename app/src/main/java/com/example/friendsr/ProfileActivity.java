package com.example.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Load the intent and retrieve the data of which friend was clicked
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // Load in the rating from shared preferences
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float StoredRating = prefs.getFloat(retrievedFriend.getName(), 0f);

        if (StoredRating != 0f){
            retrievedFriend.setRating(StoredRating);
        }

        // Set Textviews, Imageview and Ratingbar
        ((TextView) findViewById(R.id.name)).setText(retrievedFriend.getName());
        ((TextView) findViewById(R.id.biography)).setText(retrievedFriend.getBio());
        ((ImageView) findViewById(R.id.profileImage)).setImageResource(retrievedFriend.getDrawableId());
        ((RatingBar) findViewById(R.id.ratingBar)).setRating(retrievedFriend.getRating());

        RatingBar ratingBar = findViewById(R.id.ratingBar);

        // Run class RatingBarClickListener if the rating bar is clicked
        ratingBar.setOnRatingBarChangeListener(new RatingBarClickListener());
    }

    private class RatingBarClickListener implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            // Change rating according to where the rating bar is pressed
            ((RatingBar) findViewById(R.id.ratingBar)).setRating(rating);

            // Put rating into shared preferences
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(retrievedFriend.getName(), rating);
            editor.apply();
        }
    }
}
