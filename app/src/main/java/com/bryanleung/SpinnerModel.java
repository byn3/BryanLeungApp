package com.bryanleung;

/**
 * Created by byn on 8/8/2017.
 */

public class SpinnerModel {

    //setting my 3 views in the contact social activity xml
    private String SocialMedia = "";
    private String Image = "";
    private String URL = "";

    //making the get methods of above
    public String getSocialMedia() {
        return this.SocialMedia;
    }

    //setting the methods for them
    public void setSocialMedia(String SocialMedia) {
        this.SocialMedia = SocialMedia;
    }

    public String getImage() {
        return this.Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
