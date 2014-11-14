package be.vives.citroentjes.sportrijk.model;

/**
 * Created by Ik on 14/11/2014.
 */
public class Sport
{

    private String name;
    private int ID;

    public Sport()
    {

    }

    public Sport(int id, String name)
    {
        this.ID = id;
        this.name = name;
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
