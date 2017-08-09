package com.example.android.bryanleung;

/**
 * Created by Byn on 8/2/2017.
 */

public class Game {

    //creates game company name
    private String mGameCompany;
    //created image ID
    private int mImageResourceID;



    //Getter methods
    public Game(String vGameCompany, int imageResourceID){
        mGameCompany= vGameCompany;
        mImageResourceID=imageResourceID;
    }

    public String getGameCompany(){return mGameCompany;}
    public int getmImageResourceID(){return mImageResourceID;}
}

//the only purpose of this class is to get the game company name and reuse it in the ArrayAdapter