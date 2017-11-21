package com.example.mailo.takengo.models.entities;

/**
 * Created by USER on 19/11/2017.
 */

public class Car {
    int branchNum;
    CarModel carModel;
    float kilometers;
    double carNum;

    public Car() {//empty constructor
        this.branchNum =0 ;
        this.carModel = new CarModel();
        this.kilometers =0 ;
        this.carNum =0 ;
    }
    /**
     * constructor
     * @param branchNum
     * @param carModel
     * @param kilometers
     * @param carNum
     */


    public Car(int branchNum, CarModel carModel, float kilometers, int carNum) {//parameter constructor
        this.branchNum = branchNum;
        this.carModel = carModel;
        this.kilometers = kilometers;
        this.carNum = carNum;
    }

    /**
     * getter & setter
     * @return
     */
    public int getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(int branchNum) {
        this.branchNum = branchNum;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public float getKilometers() {
        return kilometers;
    }

    public void setKilometers(float kilometers) {
        this.kilometers = kilometers;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }
}

