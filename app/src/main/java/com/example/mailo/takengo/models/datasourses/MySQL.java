package com.example.mailo.takengo.models.datasourses;

import android.content.ContentValues;
import android.util.Log;

import com.example.mailo.takengo.models.backend.IDBManager;
import com.example.mailo.takengo.models.entities.Branch;
import com.example.mailo.takengo.models.entities.Car;
import com.example.mailo.takengo.models.entities.CarModel;
import com.example.mailo.takengo.models.entities.Customer;
import com.example.mailo.takengo.models.entities.User;
import com.example.mailo.takengo.models.utils.PHPtools;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 19/11/2017.
 */

public class MySQL implements IDBManager {

    private String WEB_URL ="https://shvaknin.vlab.jct.ac.il/";

    private boolean updateFlag = false;
     //help functions
    private void SetUpdate() { updateFlag = true; }
    public void printLog(String message) { Log.d (this.getClass().getName(),"\n"+message) ;}
    public void printLog(Exception message) { Log.d(this.getClass().getName(),"Exception-->\n"+message);}



    @Override
    public int isExists(ContentValues user) {
        return 0;
    }

    @Override
    public long addUser(ContentValues user) {
        try {
            String result = PHPtools.POST(WEB_URL + "add_user.php", user);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addUser:\n" + result);
            return id;
            }
        catch (IOException e)
            {
            printLog("addUser Exception:\n" + e);
            return -1;
            }
    }

    @Override
    public long addCustomer(ContentValues customer){
        try {
            String result = PHPtools.POST(WEB_URL + "add_customer.php", customer);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addCustomer:\n" + result);
            return id;
        }
        catch (IOException e)
        {
            printLog("addCustomer Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public long addCarModel(ContentValues carModel) {
        try {
            String result = PHPtools.POST(WEB_URL + "add_carModel.php", carModel);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addCarModel:\n" + result);
            return id;
        }
        catch (IOException e)
        {
            printLog("addCarModel Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public long addCar(ContentValues car) {
        try {
            String result = PHPtools.POST(WEB_URL + "add_car.php", car);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addCar:\n" + result);
            return id;
        }
        catch (IOException e)
        {
            printLog("addCar Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public long addBranch(ContentValues branch) {
        try {
            String result = PHPtools.POST(WEB_URL + "add_branch.php", branch);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addBranch:\n" + result);
            return id;
        }
        catch (IOException e)
        {
            printLog("addBranch Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public List<CarModel> getCarModel(){
        List<CarModel> result = new ArrayList<CarModel>();
        try {
            String str = PHPtools.GET(WEB_URL + "/show_carModels.php");
            JSONArray array = new JSONObject(str).getJSONArray("carModels");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                CarModel carModel = new CarModel();
                carModel.setModelCode(jsonObject.getInt("modelCode"));
                carModel.setCompanyName(jsonObject.getString("companyName"));
                carModel.setModelName(jsonObject.getString("modelName"));
                carModel.setEngineCapacity(jsonObject.getInt("engineCapacity"));
               // carModel.setGearbox(jsonObject("gearbox"));//how to convert an Enam?
                carModel.setSeats(jsonObject.getInt("seats"));
                result.add(carModel);
            }
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        List<User> result = new ArrayList<User>();
        try {
            String str = PHPtools.GET(WEB_URL + "/show_users.php");
            JSONArray array = new JSONObject(str).getJSONArray("users");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                User user = new User();
                user.setUserName(jsonObject.getString("userName"));
                user.setPassword(jsonObject.getString("password"));
                result.add(user);
            }
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }

    @Override
    public List<Branch> getBranches() {
        List<Branch> result = new ArrayList<Branch>();
        try {
            String str = PHPtools.GET(WEB_URL + "/show_branches.php");
            JSONArray array = new JSONObject(str).getJSONArray("branches");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Branch branch = new Branch();
                branch.setNumBranch(jsonObject.getInt("numBranch"));
                branch.setNumOfParkingSpaces(jsonObject.getInt("numOfParkingSpaces"));
                branch.setCity(jsonObject.getString("city"));
                branch.setStreet(jsonObject.getString("street"));
                branch.setNumber(jsonObject.getInt("number"));
                result.add(branch);
            }
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> getCars() {
        List<Car> result = new ArrayList<Car>();
        try {
            String str = PHPtools.GET(WEB_URL + "/show_cars.php");
            JSONArray array = new JSONObject(str).getJSONArray("cars");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Car car = new Car();
                car.setCarNum(jsonObject.getInt("carNum"));
                car.setNumBranch(jsonObject.getInt("branchNum"));
                car.setCarModel(jsonObject.getInt("carModel"));
                car.setKilometers(jsonObject.getInt("kilometers"));
                result.add(car);
            }
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getCustomer() {
        List<Customer> result = new ArrayList<Customer>();
        try {
            String str = PHPtools.GET(WEB_URL + "/show_customers.php");
            JSONArray array = new JSONObject(str).getJSONArray("customers");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Customer customer = new Customer();
                customer.setIdNum(jsonObject.getInt("idNum"));
                customer.setFamilyName(jsonObject.getString("familyName"));
                customer.setPrivateName(jsonObject.getString("privateName"));
                customer.setPhoneNum(jsonObject.getInt("phoneNum"));
                customer.setAddressMail(jsonObject.getString("addressMail"));
                customer.setCreditNum(jsonObject.getInt("creditNum"));
                result.add(customer);
            }
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
