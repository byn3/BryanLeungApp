package com.bryanleung;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bryanleung.SpinnerModel;

import java.util.ArrayList;

/**
 * Created by byn on 8/8/2017.
 */

public class CustomSpinnerAdapter extends ArrayAdapter<String> {

    //create global variables
    public Resources res;
    SpinnerModel tempValues = null;
    LayoutInflater inflater;
    private Activity activity;
    private ArrayList data;

    //make a custom spinner adapter Constructor
    public CustomSpinnerAdapter(
            com.bryanleung.CustomSpinner activitySpinner,
            int textViewResourceId,
            ArrayList objects,
            Resources resLocal) {
        super(activitySpinner, textViewResourceId, objects);
        //takes passed values
        activity = activitySpinner;
        data = objects;
        res = resLocal;

        //layout inflator to call external xml layout
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        //inflates contactsocialrows xml for each row
        View row = inflater.inflate(R.layout.contactsocialrows, parent, false);
        //gets model object from array list
        tempValues = null;
        tempValues = (SpinnerModel) data.get(position);

        //sets each view to the id given
        TextView socialName = (TextView) row.findViewById(R.id.socialText);
        TextView socialURL = (TextView) row.findViewById(R.id.socialUsername);
        ImageView logo = (ImageView) row.findViewById(R.id.socialImage);

        if (position == 0) {
            //default spinner item
            socialName.setText("Please Select Media");
            socialURL.setText("");
        } else {
            //set values for each row of the spinner adapter
            socialName.setText(tempValues.getSocialMedia());
            socialURL.setText(tempValues.getURL());
            logo.setImageResource(res.getIdentifier("com.bryanleung:mipmap/" + tempValues.getImage(), null, null));
        }
        return row;
    }

}
