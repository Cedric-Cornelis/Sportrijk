package be.vives.citroentjes.sportrijk.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Cedric Cornelis on 14/11/2014.
 */

public class Location {

    private int id;
    private String address;
    private String city;
    private double longitude;
    private double latitude;
    private int openDataId;

    public Location(int id, String address, String city, double longitude, double latitude, int openDataId) {
        this.address = address;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.openDataId = openDataId;
    }

    public Location(String address, String city, double longitude, double latitude, int id) {
        this.address = address;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getOpenDataId() {
        return openDataId;
    }

    public void setOpenDataId(int openDataId) {
        this.openDataId = openDataId;
    }
}
