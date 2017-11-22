package com.example.mailo.takengo.models.backend;

import android.content.ContentValues;

import com.example.mailo.takengo.models.entities.*;

import java.util.List;

/**
 * Created by USER on 19/11/2017.
* this interface Allows several operations on the DataSource .
 */

public interface IDBManager {

    public boolean isExists(User user);
    public void addUser( ContentValues user);
    public void addCarModel(ContentValues carModel);
    public void addCar(ContentValues car);
    public List<CarModel> getCarModel();
    public List<User> getUsers();
    public List<Branch> getBranches();
    public List<Car> getCars();

}
