package com.example.mailo.takengo.models.datasourses;
import com.example.mailo.takengo.models.entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 19/11/2017.
 */

public class Lists {
    static List<Branch> branches;
    static List<Car> cars;
    static List<Customer> customers;
    static List<User> users;

    public static List<Branch> getBranches() {
        return branches;
    }

    public static void setBranches(List<Branch> branches) {
        Lists.branches = branches;
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static void setCars(List<Car> cars) {
        Lists.cars = cars;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        Lists.customers = customers;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Lists.users = users;
    }

    static {
        branches=new ArrayList<>();
        cars=new ArrayList<>();
        customers=new ArrayList<>();
    }
}
