package com.example.arekr.lab3;

import java.io.Serializable;

/**
 * Created by arekr on 24/07/2016.
 */
public class Record implements Serializable {
    private String placeName = "-NA-";
    private String vicinity = "-NA-";
    private double latitude = 0;
    private double longitude = 0;
    private String reference = "";
    private double rating=0;


    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String toString(){
        return "Name:"+this.placeName+"Rating:"+this.rating;
    }
}
