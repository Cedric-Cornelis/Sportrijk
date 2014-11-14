package be.vives.citroentjes.sportrijk.model;

/**
 * Created by Ik on 14/11/2014.
 */
public class Sport
{

    private String adres;
    private String gemeente;
    private String soort;
    private String sport;
    private double longitude;
    private double latitude;

    public Sport()
    {

    }

    public Sport(String adres, String gemeente, String soort, String sport, double longitude, double latitude)
    {
        this.adres = adres;
        
    }

    public String getAdres()
    {
        return adres;
    }

    public void setAdres(String adres)
    {
        this.adres = adres;
    }

    public String getGemeente()
{
    return gemeente;
}

    public void setGemeente(String gemeente)
    {
        this.gemeente = gemeente;
    }

    public String getSoort()
    {
        return soort;
    }

    public void setSoort(String soort)
    {
        this.soort = soort;
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
