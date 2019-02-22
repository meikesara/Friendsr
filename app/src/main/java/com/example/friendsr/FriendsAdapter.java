package com.example.friendsr;

import android.content.Context;
import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;

    // Constructor
    public FriendsAdapter(Context context, int resource, ArrayList<Friend> friends_list) {
        super(context, resource, friends_list);
        friends = friends_list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Load item if it has not been loaded before
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // Create variable of current friend
        Friend current_friend = friends.get(position);

        // Set text and image view
        ((TextView) convertView.findViewById(R.id.textView)).setText(current_friend.getName());
        ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(current_friend.getDrawableId());

        return convertView;
    }
}
