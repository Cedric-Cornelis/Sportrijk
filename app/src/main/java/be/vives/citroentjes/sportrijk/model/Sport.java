package be.vives.citroentjes.sportrijk.model;

/**
 * Created by Ik on 14/11/2014.
 */
public class Sport
{

    private String name;
    private int ID;
    private Location sportLocation;

    public Sport()
    {

    }

    public Sport(String name, Location location)
    {
        this.name = name;
        sportLocation = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
