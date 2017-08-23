package com.example.android.bryanleung;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v7.widget.AppCompatDrawableManager.get;

/**
 * Created by byn on 7/24/2017.
 */


public class GamesPlayed extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_played);

        //creates array of businesses/ companies that owned the games I played
        //if I put down individual games that would be so much
        //later on I could build on this to make an onClick parent company name
        //to open up a list of their games I played.

        ArrayList<Game> gamesPlayed = new ArrayList<>();

        gamesPlayed.add(new Game("Blizzard", R.mipmap.blizzard));
        gamesPlayed.add(new Game("Supercell", R.mipmap.supercell));
        gamesPlayed.add(new Game("Wizet", R.mipmap.wizet));
        gamesPlayed.add(new Game("Softnyx", R.mipmap.softnyx));
        gamesPlayed.add(new Game("Square Enix", R.mipmap.squareenix));
        gamesPlayed.add(new Game("Nintendo", R.mipmap.nintendo));
        gamesPlayed.add(new Game("Mojang", R.mipmap.mojang));
        gamesPlayed.add(new Game("ArenaNet", R.mipmap.arenanet));
        gamesPlayed.add(new Game("Valve", R.mipmap.valve));
        gamesPlayed.add(new Game("Riot Games", R.mipmap.riotgames));
        gamesPlayed.add(new Game("Zynga", R.mipmap.zynga));
        gamesPlayed.add(new Game("Activision", R.mipmap.activision));
        gamesPlayed.add(new Game("Nexon", R.mipmap.nexon));
        gamesPlayed.add(new Game("Tencent", R.mipmap.tencent));
        //made a list of companies and matches the mwith their logos

        //makes a new adapter and sets an adapter and listview to the xml layout
        GameAdapter adapter = new GameAdapter(this, gamesPlayed);

        ListView listView = (ListView) findViewById(R.id.gamesPlayedXML);
        listView.setAdapter(adapter);


    }

}