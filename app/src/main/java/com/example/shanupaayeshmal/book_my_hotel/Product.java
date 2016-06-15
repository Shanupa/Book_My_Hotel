package com.example.shanupaayeshmal.book_my_hotel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shanupa Ayeshmal on 6/14/2016.
 */
public class Product {


    @SerializedName("hotel_id")
    public int hotel_id;

    @SerializedName("hotel_name")
    public String hotel_name;

    @SerializedName("tp_no")
    public int tp_no;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("address")
    public String address;

    @SerializedName("ac")
    public int ac;

    @SerializedName("rating")
    public int rating;

    @SerializedName("capacity")
    public int capacity;

    @SerializedName("price")
    public int price;

    @SerializedName("img")
    public String img;


}
