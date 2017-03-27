package com.example.arekr.lab3;

/**
 * Created by arekr on 21/07/2016.
 */

import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Places {

    public List<Record> parse(JSONObject jsonObject) {
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getPlaces(jsonArray);
    }

    private List<Record> getPlaces(JSONArray jsonArray) {
        int placesCount = jsonArray.length();
        List<Record> placesList = new ArrayList<Record>();
        Record placeMap = null;

        for (int i = 0; i < placesCount; i++) {
            try {
                placeMap = getPlace((JSONObject) jsonArray.get(i));
                placesList.add(placeMap);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
          System.out.println("500");
         System.out.println(placesList);
        return placesList;
    }

    private Record getPlace(JSONObject googlePlaceJson) {
        //HashMap<String, String> googlePlaceMap = new HashMap<String, String>();
        Record record=new Record();;
        String placeName = "-NA-";
        String vicinity = "-NA-";
        String latitude = "";
        String longitude = "";
        String reference = "";
        String rating="";

        try {
            if (!googlePlaceJson.isNull("name")) {
                placeName = googlePlaceJson.getString("name");
            }
            if (!googlePlaceJson.isNull("vicinity")) {
                vicinity = googlePlaceJson.getString("vicinity");
            }
            latitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");
            reference = googlePlaceJson.getString("reference");

            if (!googlePlaceJson.isNull("rating")) {
                rating = googlePlaceJson.getString("rating");
            }

            record.setPlaceName(placeName);
            try {
                double rating2=Double.parseDouble(rating);
                record.setRating(rating2);
                double latitude2=Double.parseDouble(latitude);
                record.setLatitude(latitude2);
                double longitude2=Double.parseDouble(longitude);
                record.setLongitude(longitude2);
                record.setVicinity(vicinity);
                record.setReference(reference);

            }catch(NumberFormatException e){
            }


/*
            googlePlaceMap.put("rating",rating);
            googlePlaceMap.put("place_name", placeName);
            googlePlaceMap.put("vicinity", vicinity);
            googlePlaceMap.put("lat", latitude);
            googlePlaceMap.put("lng", longitude);
            googlePlaceMap.put("reference", reference);*/

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //return googlePlaceMap;
        return record;
    }

}