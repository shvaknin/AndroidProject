package com.example.mailo.takengo.models.datasourses;
import android.content.ContentValues;

import com.example.mailo.takengo.models.backend.IDBManager;
import com.example.mailo.takengo.models.entities.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.mailo.takengo.models.utils.Constants.ContentValuesToBranch;
import static com.example.mailo.takengo.models.utils.Constants.ContentValuesToCar;
import static com.example.mailo.takengo.models.utils.Constants.ContentValuesToCarModel;
import static com.example.mailo.takengo.models.utils.Constants.ContentValuesToCustomer;
import static com.example.mailo.takengo.models.utils.Constants.ContentValuesToUser;

/**
 * Created by USER on 19/11/2017.
 */

public class Lists implements IDBManager {
    static List<Branch> branches;
    static List<Car> cars;
    static List<Customer> customers;
    static List<User> users;
    static List<CarModel> carModels;


    static {
        branches=new ArrayList<>();
        cars=new ArrayList<>();
        customers=new ArrayList<>();
        users=new ArrayList<>();
        carModels=new ArrayList<>();
    }

    @Override
    public int isExists(ContentValues values) {//check if this customer in the list
        User user= ContentValuesToUser(values);
         if(getUsers().contains(user))
             return 1;
        else return 0;

    }

    @Override
    public long addUser(ContentValues values) {
        User user= ContentValuesToUser(values);
        getUsers().add(user);
        return 0;
    }

    @Override
    public long addCustomer(ContentValues values) {
        Customer customer= ContentValuesToCustomer(values);
        getCustomer().add(customer);
        return 0;
    }

    @Override
    public long addCarModel(ContentValues values) {
        CarModel carModel= ContentValuesToCarModel(values);
        getCarModel().add(carModel);
        return 0;
    }

    @Override
    public long addBranch(ContentValues values){
        Branch branch=ContentValuesToBranch(values);
        getBranches().add(branch);
        return 0;
    }

    @Override
    public long addCar(ContentValues values) {
        Car car=ContentValuesToCar(values);
        getCars().add(car);
        return 0;
    }

    @Override
    public List<CarModel> getCarModel() {
        return carModels;
    }

    @Override
    public List<User> getUsers() {return users; }

    @Override
    public List<Branch> getBranches() {
        return branches;
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Customer> getCustomer() {
        return customers;
    }
}




