package com.example.shanupaayeshmal.book_my_hotel;

import java.util.ArrayList;

/**
 * Created by Shanupa Ayeshmal on 6/14/2016.
 */
public class LogicActivity {

    public void searchbyName(ArrayList<Product> product,ArrayList<Product> productNew, String s) {
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).hotel_name.contains("s") || product.get(i).address.contains("s")) {
                productNew.add(product.get(i));
            }
        }
    }

    //Distance from KMs
    public static double distanceCalculater(double lat1, double lat2, double lon1, double lon2) {

        final int R = 6371; // Radius of the earth

        Double latDistance = Math.toRadians(Math.abs(lat2 - lat1));
        Double lonDistance = Math.toRadians(Math.abs(lon2 - lon1));
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // convert to meters


        return distance;
    }

    public void searchbyLocation(ArrayList<Product> product, ArrayList<Product> productNew, Double longi, Double lati) {
        for (int i = 0; i < product.size(); i++) {
            double ho_lat=product.get(i).latitude;
            double ho_log=product.get(i).longitude;
            if (distanceCalculater(lati,ho_lat,longi,ho_log)<10.0) {
                productNew.add(product.get(i));
            }
        }



    }


}







