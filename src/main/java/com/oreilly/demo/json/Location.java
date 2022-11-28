package com.oreilly.demo.json;

public class Location {
    private static double lat;
    private static double lng;
    public Location(double lat,double lng){
        this.lat = lat;
        this.lng = lng;
    }

    public static double getLat() {
        return lat;
    }

    public static void setLat(double lat) {
        Location.lat = lat;
    }

    public static double getLng() {
        return lng;
    }

    public static void setLng(double lng) {
        Location.lng = lng;
    }

    @Override
    public String toString(){
        return "Location={lat="+lat+", lng="+lng+"}";
    }
}
