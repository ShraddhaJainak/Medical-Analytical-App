package com.example.lore;

import com.google.gson.annotations.SerializedName;

public class Table {

    @SerializedName("id") private  int Id;
    @SerializedName("MEDICINE_NAME") private String Medicine ;
    @SerializedName("AVAILABILITY") private String Availability ;

    @SerializedName("SHOPNAME_ADDRESS") private String Shop_Add;

    public int getId() {

        return Id;
    }

    public String getMedicine() {

        return Medicine;
    }

    public String getAvailability() {
        return Availability;
    }
    public String getShop_Add() {

        return Shop_Add;
    }

}


