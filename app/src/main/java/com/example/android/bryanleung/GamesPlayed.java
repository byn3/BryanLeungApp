package com.example.android.bryanleung;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Byn on 7/24/2017.
 */



public class GamesPlayed extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_played);

        //creates array of businesses/ companies that owned the games I played
        //usually write down the parent company, importance relevant

        ArrayList<String> games= new ArrayList<>();
        games.add("Activision/Blizzard");
        games.add("Supercell");
        games.add("Wizet/Nexon");
        games.add("Softnyx");
        games.add("Square Enix");
        games.add("Nintendo");
        games.add("Mojang");
        games.add("NCsoft/ArenaNet");
        games.add("Steam/too many to name");
        games.add("Tencent/Riot Games");
        games.add("Zynga");


        ArrayAdapter<String> gamesAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, games);
        ListView listView= (ListView) findViewById(R.id.gamesPlayedXML);
        listView.setAdapter(gamesAdapter);
    }
}

//Deals with arraylist and a while loop
//I practiced how to make the UI and xml layouts with java
//practice view recycling and memory management
//practice listview and arrayadapter and ditched the array list