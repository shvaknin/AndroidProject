package com.example.mailo.takengo.models.entities;

import java.io.Serializable;

/**
 * Created by USER on 19/11/2017.
 */

public class Branch implements Serializable {

    int numOfParkingSpaces;
    int numBranch;
    //address:
    String city;
    String street;
    int number;

    public Branch() {//empty constructor
        this.numOfParkingSpaces = 0;
        this.numBranch = 0;
        this.city = "";
        this.street = "";
        this.number = 0;
    }

    public Branch(int numOfParkingSpaces, int numBranch, String city, String street, int number) {//parameter constructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        if (numOfParkingSpaces != branch.numOfParkingSpaces) return false;
        if (numBranch != branch.numBranch) return false;
        if (number != branch.number) return false;
        if (!city.equals(branch.city)) return false;
        return street.equals(branch.street);

    }

    @Override
    public String toString() {
        return "Branch{" +
                "numOfParkingSpaces=" + numOfParkingSpaces +
                ", numBranch=" + numBranch +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}

