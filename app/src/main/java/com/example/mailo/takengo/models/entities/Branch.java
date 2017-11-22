package com.example.mailo.takengo.models.entities;

/**
 * Created by USER on 19/11/2017.
 */

public class Branch {
    int numOfParkingSpaces;
    int numBranch;
    String city;
    String street;
    int number;

    public Branch() {
        this.numOfParkingSpaces = 0;
        this.numBranch = 0;
        this.city = "";
        this.street = "";
        this.number = 0;
    }

    public Branch(int numOfParkingSpaces, int numBranch, String city, String street, int number) {
        this.numOfParkingSpaces = numOfParkingSpaces;
        this.numBranch = numBranch;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public int getNumOfParkingSpaces() {
        return numOfParkingSpaces;
    }

    public void setNumOfParkingSpaces(int numOfParkingSpaces) {
        this.numOfParkingSpaces = numOfParkingSpaces;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumBranch() {
        return numBranch;
    }

    public void setNumBranch(int numBranch) {
        this.numBranch = numBranch;
    }
}

