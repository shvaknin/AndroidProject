package com.example.mailo.takengo.models.entities;

/**
 * Created by USER on 19/11/2017.
 */

public class Branch {
    Address address;
    int numOfParkingSpaces;
    int numBranch;


    public Branch(){//empty Constructor
        this.address = new Address();
        this.numOfParkingSpaces =0 ;
        this.numBranch = 0;
    }
    /**
     * Constructor
     * @param address
     * @param numOfParkingSpaces
     * @param numBranch
     */

    public Branch(Address address, int numOfParkingSpaces, int numBranch) {//parameter Constructor
        this.address = address;
        this.numOfParkingSpaces = numOfParkingSpaces;
        this.numBranch = numBranch;
    }

    /**
     *Getter & Setter
     */
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getNumOfParkingSpaces() {
        return numOfParkingSpaces;
    }

    public void setNumOfParkingSpaces(int numOfParkingSpaces) {
        this.numOfParkingSpaces = numOfParkingSpaces;
    }

    public int getNumBranch() {
        return numBranch;
    }

    public void setNumBranch(int numBranch) {
        this.numBranch = numBranch;
    }
}

