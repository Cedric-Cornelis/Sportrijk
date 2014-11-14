package be.vives.citroentjes.sportrijk.model;

import java.util.ArrayList;
import java.util.Date;

import be.vives.citroentjes.sportrijk.enums.Experience;
import be.vives.citroentjes.sportrijk.enums.Gender;

/**
 * Created by Cedric Cornelis on 14/11/2014.
 */
public class Person {

    private String name;
    private String surName;
    private int age;
    private Gender gender;
    private String userName;
    private String passWord;
    private Experience experience;
    private Date birthDate;
    private ArrayList<Person> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public ArrayList<Person> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Person> friends) {
        this.friends = friends;
    }

    public void addFriends(Person person)
    {
        friends.add(person);
    }

    public void removeFriends(Person person)
    {
        //Moet nog controle bijkomen om te checken of de persoon nog met iemand in relatie is.
        friends.remove(friends.indexOf(person));

    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
