package com.bryanleung;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.bryanleung.CustomSpinnerAdapter;
import com.bryanleung.SpinnerModel;

import java.util.ArrayList;

/**
 * Created by byn on 8/8/2017.
 */

public class CustomSpinner extends AppCompatActivity {
    //makes a custom spinner adapter for my social media
    public ArrayList<SpinnerModel> CustomSocialSpinnerArray = new ArrayList<>();
    TextView belowSpinner = null;
    CustomSpinnerAdapter adapter;
    CustomSpinner activity = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_social);

        activity = this;
        //uses my xml ids to connect these expressions
        Spinner SpinnerExample = (Spinner) findViewById(R.id.socialSpinner);
        belowSpinner = (TextView) findViewById(R.id.belowSpinner);

        //This is the data passed and setting the adapter
        setListData();
        Resources res = getResources();
        adapter = new CustomSpinnerAdapter(activity, R.layout.contactsocialrows, CustomSocialSpinnerArray, res);
        SpinnerExample.setAdapter(adapter);

        //waits for an item to be clicked on
        SpinnerExample.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                String Social = ((TextView) view.findViewById(R.id.socialText)).getText().toString();
                String SocialURL = ((TextView) view.findViewById(R.id.socialUsername)).getText().toString();

                //deleted SocialURL in the string to prevent duplicate text. replaced with string go stalk me
                String OutputMessage = "Selected Media: \n\n" + Social + "\n\n" + "Go look me up and stalk me.";
                belowSpinner.setText(OutputMessage);


                //didnt need my toast message below.
                // Toast.makeText(getApplicationContext(),OutputMessage,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing on nothing
            }
        });
    }

    //sets data into arraylist
    public void setListData() {
        String socialMedia[] = {"", "GitHub", "Twitch", "Facebook", "Youtube", "Instagram"};
        //putting my social media descriptions here in an array
        //probably should not hard code the string but I can fix that later
        //added an empty string because the loop skipped the first github element
        String description[] = {"",
                "/byn3. So far it only has my one app(this) and the snake game in this app. Using this to learn Git and version control.",
                "/byn3. I stream my World of Warcraft gameplay with my guild and other games with my friends. I am in a top US guild and ranked high in many different games. This is my main hobby. This is what you can use to break the ice with me.",
                "/bynleung. I have not used this in a couple of years, but if you need to snoop, go ahead. If there is anything crude that I posted years ago, it definitely does not represent me now.",
                "/channel/UCiiE0vjXzLJb199h9EDxnEg. I make videos for fun and for my friends. These are virtual memories and good times that I try to preserve for nostalgia. A related note-- some videos are unfiltered and contain vulgarities. A majority of the time, we are nice and quiet but that is not as entertaining as our rowdy times. As evidence, you can watch my twitch streams and see myself not uttering one word. I have some meme and parody videos too.",
                "/byn333. Check out my IG. In these videos I can be over dramatic, oozing with sarcasm, or teasing my love. Remember, this is for entertainment and does not reflect how I am professionally."};

        //a loop for each element in the list.
        //sets each social media label, image associated with it, and the url plus my description
        for (int i = 0; i < socialMedia.length; i++) {
            final SpinnerModel bryan = new SpinnerModel();
            //takes data in model object
            bryan.setSocialMedia(socialMedia[i]);
            bryan.setImage("image" + (i));
            bryan.setURL("http://www." + socialMedia[i] + ".com" + description[i]);

            //takes the above model object in array list
            CustomSocialSpinnerArray.add(bryan);
        }
    }

}
