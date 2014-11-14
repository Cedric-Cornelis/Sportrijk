package be.vives.citroentjes.sportrijk.model;

/**
 * Created by Ik on 14/11/2014.
 */
public class Sport
{

    private String address;
    private String city;
    private String type;
    private String sport;
    private double longitude;
    private double latitude;

    public Sport()
    {

    }

    public Sport(String address, String city, String type, String sport, double longitude, double latitude)
    {
        this.address = address;
        this.city = city;
        this.type = type;
        this.sport = sport;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
{
    return city;
}

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getSport()
    {
        return sport;
    }

    public void setSport(String sport)
    {
        this.sport = sport;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }
}
