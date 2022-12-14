package com.oreilly.demo.json;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;


public class Site {
    private Integer id;
    private String address;
    private double latitude;
    private double longitude;

    public Site() {
    }

    public Site(String formattedAddress, double latitude, double longitude) {
        this.address = formattedAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Site(String formattedAddress) {
        this.address = formattedAddress;
        this.latitude = 0;
        this.longitude = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
