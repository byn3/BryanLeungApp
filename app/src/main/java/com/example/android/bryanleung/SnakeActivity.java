package com.example.android.bryanleung;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;


/**
 * Created by byn on 7/27/2017.
 */


public class SnakeActivity extends AppCompatActivity {

    //declare an instance of SnakeView
    SnakeView snakeView;

    //initialize it in onCreate
    //once we have more details about the Player's device
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //find out the width and height of the screen
        Display display = getWindowManager().getDefaultDisplay();

        //load the resolution into a Point object
        Point size = new Point();
        display.getSize(size);

        //create a new View based on the SnakeView class
        snakeView = new SnakeView(this, size);

        //make snakeView the default view of the Activity
        setContentView(snakeView);
    }

    //start the thread in snakeView when this activity is shown to the player
    @Override
    protected void onResume() {
        super.onResume();
        snakeView.resume();
    }

    //make sure the thread in snakeView is stopped if this activity is about to be closed
    @Override
    protected void onPause() {
        super.onPause();
        snakeView.pause();
    }
}