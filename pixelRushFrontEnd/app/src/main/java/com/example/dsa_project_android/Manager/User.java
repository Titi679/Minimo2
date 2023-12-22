package com.example.dsa_project_android.Manager;

import java.util.ArrayList;
import java.util.List;
public class User {
    String username;
    String password;
    String mail;
    String name;
    String surname;
    String photo; //.png or .jpg <img src="photo.jpg"> (Front-end job)
    String state;
    int age;
    int pointsEarned; //We need an attribute points to buy!!!!!
    //Played Matches list
    List<Match> matchesPlayed;
    //list of owned objects;
    List<StoreObject> ownedObjects;

    public User(String username, String password, String mail, String name,
                String surname, int age) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.photo = null; //user will put a photo after the register
        this.state = null; //same as photo
        this.age = age;
        this.matchesPlayed = new ArrayList<>();//create empty lists of matches
        this.ownedObjects = new ArrayList<>();//create empty list of owned objects
        this.pointsEarned = 0;//User starts with 0 points earned
    }
}
