package com.example.gmamdin.apicall;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PlacesList {
    @SerializedName("places_list")
    private ArrayList<Places> placeList;

    public ArrayList<Places> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(ArrayList<Places> placeList) {
        this.placeList = placeList;
    }



}
