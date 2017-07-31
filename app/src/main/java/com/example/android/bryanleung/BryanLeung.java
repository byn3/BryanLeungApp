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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bryanleung);

        //makes a welcome message
        //change and edit so nor hard stringed or whatnot
        Toast.makeText(BryanLeung.this,"You so dam sexy and awesome", Toast.LENGTH_SHORT).show();
    }
    public void AboutMe(View view){
        Intent i=new Intent(this, AboutMe.class);
        startActivity(i);
    }
    public void ContactSocial(View view){
        Intent i=new Intent(this, ContactSocial.class);
        startActivity(i);
    }
    public void PlacesVisited(View view){
        Intent i=new Intent(this, PlacesVisited.class);
        startActivity(i);
    }
    public void GamesPlayed(View view) {
        Intent i = new Intent(this, GamesPlayed.class);
        startActivity(i);
    }
    public void SnakeActivity(View view) {
        Intent i = new Intent(this, SnakeActivity.class);
        startActivity(i);
    }
}
//fix the constraint layouts and start working on the xml and activities of the other apps. do features.
