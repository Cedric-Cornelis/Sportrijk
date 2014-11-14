package be.vives.citroentjes.sportrijk.model;

import java.util.ArrayList;

import be.vives.citroentjes.sportrijk.enums.Experience;

/**
 * Created by Cedric Cornelis on 14/11/2014.
 */
public class Person {

    private String name;
    private String surName;
    private int age;
    private String userName;
    private String passWord;
    private Experience experience;
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
}
