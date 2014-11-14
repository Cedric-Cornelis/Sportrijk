package be.vives.citroentjes.sportrijk.model;

import java.util.Date;

/**
 * Created by Cedric Cornelis on 14/11/2014.
 */

public class Location {

    private String address;
    private String city;
    private double longitude;
    private double latitude;
    private int openDataId;
    private Date timeUpdate;

    public Location(String adres, String city, double longitude, double latitude, int openDataId, Date timeUpdate) {
        this.address = adres;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.openDataId = openDataId;
        this.timeUpdate = timeUpdate;
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

    public Date getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(Date timeUpdate) {
        this.timeUpdate = timeUpdate;
    }
}
