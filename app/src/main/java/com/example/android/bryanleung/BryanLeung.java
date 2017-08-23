package com.example.android.bryanleung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.android.bryanleung.R.layout.bryanleung;
import static java.security.AccessController.getContext;

public class BryanLeung extends AppCompatActivity {
    //this is my home screen of the app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bryanleung);

        //makes a welcome message
        //plays around with toast
        Toast.makeText(BryanLeung.this, "You so dam sexy and awesome", Toast.LENGTH_SHORT).show();
    }

    public void AboutMe(View view) {
        //opens about me
        Intent i = new Intent(this, AboutMe.class);
        startActivity(i);
    }

    public void CustomSpinner(View view) {
        //opens the social media
        Intent i = new Intent(this, CustomSpinner.class);
        startActivity(i);
    }

    public void PlacesVisited(View view) {
        //this is actually the phone intents file
        //I was going to make a story here but instead I decided to practice phone intents
        Intent i = new Intent(this, PlacesVisited.class);
        startActivity(i);
    }

    public void GamesPlayed(View view) {
        //this was my first custom adapter, opens games played
        Intent i = new Intent(this, GamesPlayed.class);
        startActivity(i);
    }

    public void SnakeActivity(View view) {
        //opens up a snake game coded in java, very basic
        Intent i = new Intent(this, SnakeActivity.class);
        startActivity(i);
    }
}
