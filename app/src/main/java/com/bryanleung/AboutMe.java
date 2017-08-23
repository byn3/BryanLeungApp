package com.bryanleung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutMe extends AppCompatActivity {
    //when about button is clicked, opens the activity_about_me.xml
    //which is just a linear layout with a scroll view and text view inside that
    //a long string is the text view. more info is hidden and located in my strings.xml file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }
}
