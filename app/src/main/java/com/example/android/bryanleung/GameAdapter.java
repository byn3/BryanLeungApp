package com.example.android.bryanleung;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by byn on 8/2/2017.
 */

public class GameAdapter extends ArrayAdapter<Game> {

    public GameAdapter(Activity context, ArrayList<Game> games) {
        // make the GameAdapter's internal storage for the context and the list.
        // the second argument is used when GameAdapter is populating a single TextView.
        // this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. so we used 0.
        super(context, 0, games);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // see if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.gamesplayedlayout, parent, false);
        }

        // Get the object located at this position in the list
        Game currentGame = getItem(position);

        // Find the TextView in the games_played.xml layout with the ID gameCompanyName
        TextView gameTextView = (TextView) listItemView.findViewById(R.id.gameCompanyName);
        // Get the came company name from the current Game object and
        // set this text on the name gameTextView
        gameTextView.setText(currentGame.getGameCompany());

        // Find the ImageView in the games_played.xml layout with the ID gameCompanyIcon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.gameCompanyIcon);
        // Get the image res ID from the current Game object and
        // set the image to iconView
        iconView.setImageResource(currentGame.getmImageResourceID());

        // Return the whole list item layout (containing 1 [but can hold 2] TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
