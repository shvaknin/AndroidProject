package com.example.mailo.takengo.models.datasourses;
import android.content.ContentValues;

import com.example.mailo.takengo.models.backend.IDBManager;
import com.example.mailo.takengo.models.entities.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.mailo.takengo.models.utils.Constants.ContentValuesToCar;
import static com.example.mailo.takengo.models.utils.Constants.ContentValuesToCarModel;
import static com.example.mailo.takengo.models.utils.Constants.ContentValuesToUser;

/**
 * Created by USER on 19/11/2017.
 */

public class Lists implements IDBManager {
    static List<Branch> branches;
    static List<Car> cars;
    static List<Customer> customers;
    static List<User> users;


    static {
        branches=new ArrayList<>();
        cars=new ArrayList<>();
        customers=new ArrayList<>();
        users=new ArrayList<>();
    }

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




