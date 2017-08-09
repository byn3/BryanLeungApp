package com.example.android.bryanleung;

/**
 * Created by Byn on 8/8/2017.
 */

public class SpinnerModel {

    //setting my 3 views in the contact social activity xml
    private String SocialMedia="";
    private String Image="";
    private String URL="";

    //setting the methods for them
    public void setSocialMedia(String SocialMedia){this.SocialMedia=SocialMedia;}
    public void setImage(String Image){this.Image=Image;}
    public void setURL(String URL){this.URL=URL;}

    //making the get methods of above
    public String getSocialMedia() {return this.SocialMedia;}
    public String getImage() {return this.Image;}
    public String getURL() {return this.URL;}


}
