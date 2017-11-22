package com.example.mailo.takengo.models.entities;

/**
 * Created by USER on 19/11/2017.
 */

public class Address {
    String city;
    String street;
    int number;

    public Address() {//empty Constructor
        this.city ="" ;
        this.street = "";
        this.number = 4;
    }
    /**
     * Constructor
     * @param city
     * @param street
     * @param number
     */

    public Address(String city, String street, int number) {//parameter Constructor
        this.city = city;
        this.street = street;
        this.number = number;
    }

    /**
     *Getter & Setter
     */
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
}

