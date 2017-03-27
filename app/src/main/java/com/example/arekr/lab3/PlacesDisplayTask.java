package com.example.arekr.lab3;

/**
 * Created by arekr on 21/07/2016.
 */

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class PlacesDisplayTask extends AsyncTask<Object, Integer, List<Record>>  {
   public static List<Record> recordsnew;
    JSONObject googlePlacesJson;
     static GoogleMap googleMap;

    @Override
    protected List<Record> doInBackground(Object... inputObj) {

        List<Record> googlePlacesList = null;
        Places placeJsonParser = new Places();

        try {
            googleMap = (GoogleMap) inputObj[0];
            googlePlacesJson = new JSONObject((String) inputObj[1]);
            googlePlacesList = placeJsonParser.parse(googlePlacesJson);
        } catch (Exception e) {
            Log.d("Exception", e.toString());
        }
        return googlePlacesList;
    }

    @Override
    protected void onPostExecute(List<Record> list) {
        try{
        for (int i = 0; i < list.size(); i++) {

            MarkerOptions markerOptions = new MarkerOptions();
            Record googlePlace = list.get(i);
            double lat = (googlePlace.getLatitude());
            double lng = (googlePlace.getLongitude());
            String placeName = googlePlace.getPlaceName();
            String vicinity = googlePlace.getVicinity();
            LatLng latLng = new LatLng(lat, lng);
            markerOptions.position(latLng);
            markerOptions.title(placeName + " : " + vicinity);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            MapsActivity.mMap.addMarker(markerOptions);

        }
        Collections.sort(list,new MyRatingComp());
            setRecordsnew(new ArrayList<Record>());
            setRecordsnew(list);
            System.out.println("Collections.sort");



        }catch (NumberFormatException e) {
        }
    }

    public List<Record> getRecordsnew() {
        return recordsnew;
    }

    public void setRecordsnew(List<Record> recordsnew) {
        PlacesDisplayTask.recordsnew = recordsnew;
    }

    class MyRatingComp implements Comparator<Record>{
                @Override
        public int compare(Record e1, Record e2) {
            if(e1.getRating() < e2.getRating()){
                return 1;
                } else {
                return -1;
                }
            }
    }



}


