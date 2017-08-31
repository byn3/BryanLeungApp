package com.bryanleung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutMe extends AppCompatActivity {

    // uploaded these images http://imgur.com/a/Hq2C6


    //learned to use the picasso library to add a image url as an imageView
    ImageView bynURL1;
    ImageView bynURL2;
    ImageView bynURL3;
    ImageView bynURL4;
    ImageView bynURL5;
    ImageView bynURL6;

    //when about button is clicked, opens the activity_about_me.xml
    //which is just a linear layout with a scroll view and text view inside that
    //a long string is the text view. more info is hidden and located in my strings.xml file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);


        bynURL1 = (ImageView)findViewById(R.id.bynURL1);
        bynURL2 = (ImageView)findViewById(R.id.bynURL2);
        bynURL3 = (ImageView)findViewById(R.id.bynURL3);
        bynURL4 = (ImageView)findViewById(R.id.bynURL4);
        bynURL5 = (ImageView)findViewById(R.id.bynURL5);
        bynURL6 = (ImageView)findViewById(R.id.bynURL6);

        //babysitting first cousins once removed
        Picasso.with(getApplicationContext())
                .load("http://i.imgur.com/EjAOEgW.jpg")
                .placeholder(R.drawable.mountain)
                .error(R.drawable.computer)
                .fit()
                .into(bynURL1);


        //chilling in Costa Rica
        Picasso.with(getApplicationContext())
                .load("http://i.imgur.com/kPXGc54.jpg")
                .placeholder(R.drawable.mountain)
                .error(R.drawable.computer)
                .fit()
                .into(bynURL2);

        //beekeeping
        Picasso.with(getApplicationContext())
                .load("http://i.imgur.com/prgpwP0.jpg")
                .placeholder(R.drawable.mountain)
                .error(R.drawable.computer)
                .fit()
                .into(bynURL3);

        //hiking in hawaii
        Picasso.with(getApplicationContext())
                .load("http://i.imgur.com/0kvtzum.jpg.jpg")
                .placeholder(R.drawable.mountain)
                .error(R.drawable.computer)
                .fit()
                .into(bynURL4);

        //so gangsta it hurts. image is landscape and is distorted when phone is portrait
        Picasso.with(getApplicationContext())
                .load("http://i.imgur.com/SvGSCoJ.jpg.jpg")
                .placeholder(R.drawable.mountain)
                .error(R.drawable.computer)
                .fit()
                .into(bynURL5);

        //me as a hip and cool farmer
        Picasso.with(getApplicationContext())
                .load("http://i.imgur.com/VyzKdrQ.jpg.jpg")
                .placeholder(R.drawable.mountain)
                .error(R.drawable.computer)
                .fit()
                .into(bynURL6);
    }
}
