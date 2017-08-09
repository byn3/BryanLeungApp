package com.example.android.bryanleung;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;

/**
 * Created by Byn on 8/8/2017.
 */

public class CustomSpinner extends Activity{

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

                String OutputMessage="Selected Company: \n\n"+Social+"\n"+SocialURL;
                belowSpinner.setText(OutputMessage);

                Toast.makeText(getApplicationContext(),OutputMessage,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            //do nothing on nothing
            }
        });
    }

    //sets dats into arraylist
    public void setListData(){
        String socialMedia[]={"GitHub","Twitch","Facebook","Youtube","Instagram"};
        for (int i=0; i<socialMedia.length; i++) {
            final SpinnerModel bryan = new SpinnerModel();

            //takes data in model object
            bryan.setSocialMedia(socialMedia[i]);
            bryan.setImage("image"+i);
            bryan.setURL("http:\\\\www."+socialMedia[i]+".com");

            //takes the above model object in array list
            CustomSocialSpinnerArray.add(bryan);
        }
    }

}
