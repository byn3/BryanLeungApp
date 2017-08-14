package com.example.android.bryanleung;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;

import static android.R.attr.description;

/**
 * Created by Byn on 8/8/2017.
 */

public class CustomSpinner extends AppCompatActivity{

    public ArrayList<SpinnerModel> CustomSocialSpinnerArray=new ArrayList<>();
    TextView belowSpinner=null;
    CustomSpinnerAdapter adapter;
    CustomSpinner activity=null;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_social);

        activity=this;

        Spinner SpinnerExample=(Spinner)findViewById(R.id.socialSpinner);
        belowSpinner=(TextView)findViewById(R.id.belowSpinner);



        setListData();
        Resources res=getResources();
        adapter=new CustomSpinnerAdapter(activity,R.layout.contactsocialrows,CustomSocialSpinnerArray,res);
        SpinnerExample.setAdapter(adapter);

        SpinnerExample.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                String Social=((TextView) view.findViewById(R.id.socialText)).getText().toString();
                String SocialURL=((TextView) view.findViewById(R.id.socialUsername)).getText().toString();

               //deleted SocialURL in the string to prevent duplicate
                String OutputMessage="Selected Media: \n\n" + Social + "\n\n" + "Go stalk me.";
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

    //sets datas into arraylist
    public void setListData(){
        String socialMedia[]={"","GitHub","Twitch","Facebook","Youtube","Instagram"};
        //putting my social media descriptions here in an array
        String description[]={"",
                "/byn3. So far it only has my one app(this) and the primitive snake game in this app. Using this to learn Git and version control.",
                "/byn3. I stream my World of Warcraft gameplay with my guild and other games with my friends. I am in a top US guild and ranked high in many different games. This is my main hobby. This is what you can use to break the ice with me.",
                "/bynleung. I have not used this in a couple of years, but if you need to snoop, I have nothing to hide. If there is anything crude that I posted years ago, it definitely does not represent me now.",
                "/channel/UCiiE0vjXzLJb199h9EDxnEg. I make videos for fun and for my friends. These are virtual memories and good times that I try to preserve for nostalgia. A related note-- some videos are unfiltered and contain vulgarities. A majority of the time, we are kind and quiet but that is not as entertaining as our loud and brash times. As evidence, you can watch my twitch streams and see myself not uttering one word. I have some meme and parody videos too.",
                "/byn333. If you wanted to stalk me more, check out my IG. In these videos I can be over dramatic, oozing with sarcasm, or teasing my love."};

        for (int i=0; i<socialMedia.length;i++) {
            final SpinnerModel bryan = new SpinnerModel();
            //takes data in model object
            bryan.setSocialMedia(socialMedia[i]);
            bryan.setImage("image"+(i));
            bryan.setURL("http://www."+socialMedia[i]+".com"+description[i]);

            //takes the above model object in array list
            CustomSocialSpinnerArray.add(bryan);
        }
    }

}
