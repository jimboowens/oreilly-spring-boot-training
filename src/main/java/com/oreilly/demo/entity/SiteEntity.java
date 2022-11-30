package com.oreilly.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.stereotype.Component;


@Entity
public class SiteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private double latitude;
    private double longitude;

    public SiteEntity() {
    }

    public SiteEntity(String formattedAddress, double latitude, double longitude) {
        this.address = formattedAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public SiteEntity(String formattedAddress) {
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
        return "SiteEntity{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
