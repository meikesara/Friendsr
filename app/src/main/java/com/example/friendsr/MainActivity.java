package com.example.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RatingBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Create variables friends and adapter
    ArrayList<Friend> friends = new ArrayList<>();
    FriendsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create variables of the friend class
        Friend arya = new Friend("Arya",
                "Arya Stark is the third child and second daughter of Lord Eddard Stark and his wife, Lady Catelyn Stark.",
                getResources().getIdentifier("arya", "drawable", getPackageName()));
        Friend cersei = new Friend(
                "Cersei",
                "Queen Cersei I Lannister is the widow of King Robert Baratheon.",
                getResources().getIdentifier("cersei", "drawable", getPackageName()));
        Friend daenerys = new Friend(
                "Daenerys",
                "Queen Daenerys Targaryen, also known as Dany and Daenerys Stormborn, is the younger sister of Rhaegar Targaryen and Viserys Targaryen and only daughter of King Aerys II Targaryen and Queen Rhaella Targaryen.",
                getResources().getIdentifier("daenerys", "drawable", getPackageName()));
        Friend jaime = new Friend(
                "Jaime",
                "Ser Jaime Lannister is the eldest son of Tywin, younger twin brother of Cersei, and older brother of Tyrion Lannister.",
                getResources().getIdentifier("jaime", "drawable", getPackageName()));
        Friend jon = new Friend(
                "Jon",
                "Jon Snow, born Aegon Targaryen, is the son of Lyanna Stark and Rhaegar Targaryen, the late Prince of Dragonstone.",
                getResources().getIdentifier("jon", "drawable", getPackageName()));
        Friend jorah = new Friend(
                "Jorah",
                "Ser Jorah Mormont is a formerly exiled Northern lord from Westeros previously living in Essos.",
                getResources().getIdentifier("jorah", "drawable", getPackageName()));
        Friend margaery = new Friend(
                "Margaery",
                "Queen Margaery Tyrell was the only daughter of Lord Mace Tyrell and Lady Alerie Tyrell, granddaughter of Lady Olenna Tyrell and sister of Ser Loras Tyrell.",
                getResources().getIdentifier("margaery", "drawable", getPackageName()));
        Friend melisandre = new Friend(
                "Melisandre",
                "Melisandre, often referred to as the Red Woman, is a Red Priestess in the religion of R'hllor, the Lord of Light, and a close counselor to Stannis Baratheon in his campaign to take the Iron Throne.",
                getResources().getIdentifier("melisandre", "drawable", getPackageName()));
        Friend sansa = new Friend(
                "Sansa",
                "Lady Sansa Stark is the eldest daughter of Lord Eddard Stark of Winterfell and his wife Lady Catelyn, sister of Robb, Arya, Bran and Rickon Stark, and \"half-sister\" of Jon Snow.",
                getResources().getIdentifier("sansa", "drawable", getPackageName()));
        Friend tyrion = new Friend(
                "Tyrion",
                "Lord Tyrion Lannister is the youngest child of Lord Tywin Lannister and younger brother of Cersei and Jaime Lannister. A dwarf, he uses his wit and intellect to overcome the prejudice he faces.",
                getResources().getIdentifier("tyrion", "drawable", getPackageName()));

        // Add friends to list
        friends.add(arya);
        friends.add(cersei);
        friends.add(daenerys);
        friends.add(jaime);
        friends.add(jon);
        friends.add(jorah);
        friends.add(margaery);
        friends.add(melisandre);
        friends.add(sansa);
        friends.add(tyrion);

        // Define the adapter
        adapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        // Find grid-view and set adapter to it
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

        // If a grid-item is clicked run class GridItemClickListener
        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    // Create class that runs whenever a grid-item is clicked
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // Create variable of the specific friend that was clicked
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            // Put the clickedFriend variable in the intent and load ProfileActivity
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
