package com.example.mailo.takengo.models.backend;

import android.content.ContentValues;

import com.example.mailo.takengo.models.entities.Branch;
import com.example.mailo.takengo.models.entities.Car;
import com.example.mailo.takengo.models.entities.CarModel;
import com.example.mailo.takengo.models.entities.User;

import java.util.List;

import static com.example.mailo.takengo.models.utils.Constants.*;

/**
 * class which implements the interface IDBManager.
 * Created by USER on 19/11/2017.
 */

public class DBManagerFactory implements IDBManager {

    @Override
    public boolean isExists(User user) {//check if this user in the list
        return getUsers().contains(user);

    }

    @Override
    public void addUser(ContentValues values) {
        User user= ContentValuesToUser(values);
        getUsers().add(user);
    }

    @Override
    public void addCarModel(ContentValues values) {
        CarModel carModel= ContentValuesToCarModel(values);
        getCarModel().add(carModel);
    }

    @Override
    public void addCar(ContentValues values) {
        Car car=ContentValuesToCar(values);
        getCars().add(car);
    }

    @Override
    public List<CarModel> getCarModel() {
        return getCarModel();
    }

    @Override
    public List<User> getUsers() {
        return getUsers();
    }

    @Override
    public List<Branch> getBranches() {
        return getBranches();
    }

    @Override
    public List<Car> getCars() {
        return getCars();
    }
}
