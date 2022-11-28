package com.oreilly.demo.json;

import java.util.List;

public class GeocodingResult {

    private String formattedAddress;
    private Geometry geometry;

    public GeocodingResult(String formattedAddress, Geometry geometry){
        this.formattedAddress = formattedAddress;
        this.geometry = geometry;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "GeocodingResult{" +
                "formattedAddress='" + formattedAddress + '\'' +
                ", geometry=" + geometry +
                '}';
    }



}