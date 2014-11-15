package be.vives.citroentjes.sportrijk.model;

/**
 * Created by Ik on 14/11/2014.
 */
public class Sport
{

    private String name;
    private int id;
    private Location sportLocation;

    public Sport()
    {

    }

        public Sport(int id, String name, Location location)
    {
        this.name = name;
        sportLocation = location;
        this.id = id;
    }

    public Sport(String name, Location locationObject) {
        this.name = name;
        sportLocation = locationObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public Location getLocation()
    {
        return sportLocation;
    }

    public void setLocation(Location locationObject)
    {
        this.sportLocation = locationObject;
    }
}
