package com.example.android.bryanleung;

/**
 * Created by byn on 8/2/2017.
 */

public class Game {
    //the only purpose of this class is to get the game company name and reuse it in the GameAdapter

    //creates game company name
    private String mGameCompany;
    //created image ID
    private int mImageResourceID;

    //getter methods
    public Game(String vGameCompany, int imageResourceID) {
        mGameCompany = vGameCompany;
        mImageResourceID = imageResourceID;
    }

    //return functions
    public String getGameCompany() {
        return mGameCompany;
    }

    public int getmImageResourceID() {
        return mImageResourceID;
    }
}
