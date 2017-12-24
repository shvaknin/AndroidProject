package com.example.mailo.takengo.models.entities;

/**
 * Created by USER on 19/11/2017.
 */

public class CarModel {
    int modelCode;
    String companyName;
    String modelName;
    float engineCapacity;
    Gearbox gearbox;
    int seats;

    public CarModel() {//empty constructor
        this.modelCode = 0;
        this.companyName = "";
        this.modelName = "";
        this.engineCapacity = 0;
        this.gearbox = Gearbox.Automatic;
        this.seats = 0;
    }

    /**
     * constructor
     *
     * @param modelCode
     * @param companyName
     * @param modelName
     * @param engineCapacity
     * @param gearbox
     * @param seats
     */
    public CarModel(int modelCode, String companyName, String modelName, float engineCapacity, Gearbox gearbox, int seats) {//parameter constructor
        this.modelCode = modelCode;
        this.companyName = companyName;
        this.modelName = modelName;
        this.engineCapacity = engineCapacity;
        this.gearbox = gearbox;
        this.seats = seats;
    }

    /**
     * getter & setter
     */
    public int getModelCode() {
        return modelCode;
    }

    public void setModelCode(int modelCode) {
        this.modelCode = modelCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public float getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarModel carModel = (CarModel) o;

        if (modelCode != carModel.modelCode) return false;
        if (Float.compare(carModel.engineCapacity, engineCapacity) != 0) return false;
        if (seats != carModel.seats) return false;
        if (!companyName.equals(carModel.companyName)) return false;
        if (!modelName.equals(carModel.modelName)) return false;
        return gearbox == carModel.gearbox;

    }

    @Override
    public String toString() {
        return  modelName+" " + modelCode;
    }
}

