package be.vives.citroentjes.sportrijk.model;

import java.util.Calendar;
import java.util.Date;

import be.vives.citroentjes.sportrijk.enums.Gender;
import be.vives.citroentjes.sportrijk.enums.Level;

/**
 * Created by Cedric Cornelis on 14/11/2014.
 */
public class Person {

    private int ID;
    private String name;
    private String surname;
    private Date birthdate;
    private Gender sex;
    private Level level;
    private String username;
    private String password;
    private String email;

    public Person()
    {

    }

    public Person(int id, String n, String sn, Date bday, Gender s, Level l, String un, String pw, String e)
    {
        this.ID = id;
        this.name = n;
        this.surname = sn;
        this.birthdate = bday;
        this.sex = s;
        this.level = l;
        this.username = un;
        this.password = pw;
        this.email = e;
    }

    public int getAge(Date bd)
    {
        Calendar dob = Calendar.getInstance();
        dob.setTime(bd);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if(today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
        {
            age--;
        }
        return age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
