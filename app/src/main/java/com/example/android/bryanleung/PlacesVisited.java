package com.example.android.bryanleung;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import java.util.Locale;


public class PlacesVisited extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_visited);

        Button one = (Button) findViewById(R.id.button1);
        one.setOnClickListener(this); //calls onclick method for button1
        Button two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this); //calls onclick method for button2
        Button three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this); //calls onclick method for button3
        Button four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(this); //calls onclick method for button4
        Button five = (Button) findViewById(R.id.button5);
        five.setOnClickListener(this); //calls onclick method for button5
        Button six = (Button) findViewById(R.id.button6);
        six.setOnClickListener(this); //calls onclick method for button 6
    }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    //easiest case here. simple use camera button
                    Intent intent1 = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivity(intent1);
                    break;
                case R.id.button2:
                    //opens an email intent and already puts in default reach out message
                    Intent intent2 = new Intent(Intent.ACTION_SEND);
                    intent2.setType("plain/text");
                    intent2.putExtra(Intent.EXTRA_EMAIL, new String[] {"BryanLeung92@gmail.com"});
                    intent2.putExtra(Intent.EXTRA_SUBJECT, "Hey cutie");
                    intent2.putExtra(Intent.EXTRA_TEXT, "I used and like your app. Here's my contact info. (INSERT VERY PERSONAL INFO HERE =P)");
                    startActivity(Intent.createChooser(intent2, ""));
                    break;
                case R.id.button3:
                    //opens to the general San Bruno Area I live in. Dont want no crazy stalker knowing my exact place where i sleep
                    //zooms into the SB library since I live near here
                    Intent intent3 = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/maps/@37.6251111,-122.4147913,19z"));
                    startActivity(intent3);
                    break;
                case R.id.button4:
                    //no intent sends a text
                    //pretty much instant
                    String phoneNumber = "6504552948";
                    String messageToSend = "Olive Juice. Here is my number. I want to hear your voice.";
                    SmsManager.getDefault().sendTextMessage(phoneNumber, null, messageToSend, null,null);
                    break;
                case R.id.button5:
                    //call me and leave a voice mail cause i wont pick up
                    //i get so many fake calls or telemarketers. if it aint a number im expecting or a number i know i let it go to voice mail
                    //if its an important message usually they just gotta say call me back and i will
                    Uri BryansNumber= Uri.parse("tel:6504552948");
                    Intent intent5= new Intent(Intent.ACTION_DIAL, BryansNumber);
                    startActivity(intent5);
                    break;
                case R.id.button6:
                    //I put some photos of me and my family online to test this
                    Uri imgurURI = Uri.parse("http://imgur.com/a/evD64\n"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, imgurURI);
                    startActivity(intent);
                    break;
            }
        }
}

