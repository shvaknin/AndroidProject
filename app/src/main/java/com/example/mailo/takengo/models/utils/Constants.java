package com.example.mailo.takengo.models.utils;
import android.content.ContentValues;
import com.example.mailo.takengo.models.entities.*;

/**
 * Auxiliary departments for the regular departments
 * Created by USER on 19/11/2017.
 */

public class Constants {

    public static class AddressConst{
        public static final String CITY="city";
        public static final String STREET="street";
        public static final String NUMBER="number";
    }
    public static class BranchConst{
        public static final String ADDRESS="address";
        public static final String NUM_OF_PARKING_SPACES="numOfParkingSpaces";
        public static final String NUM_BRANCH="numBranch";
    }
    public static class CarConst{
        public static final String BRANCH_NUM="branchNum";
        public static final String CAR_MODEL="carModel";
        public static final String KILOMATERS="kilometers";
        public static final String CAR_NUM="carNum";

    }
    public static class CarModelConst{
        public static final String MODEL_CODE="modelCode";
        public static final String COMPANY_NAME="companyName";
        public static final String MODEL_NAME="modelName";
        public static final String ENGINE_CAPACITY="engineCapacity";
        public static final String GEARBOX="gearbox";
        public static final String SEATS="seats";

    }
    public static class CustomerConst{
        public static final String FAMILY_NAME="familyName";
        public static final String PRIVATE_NAME="privateName";
        public static final String ID_NUM="idNum";
        public static final String PHONE_NUM="phoneNum";
        public static final String ADDRESS_MAIL="addressMail";
        public static final String CREDIT_NUM="creditNum";

    }

    public static class UserConst{
        public static final String USER_NAME = "userName";
        public static final String PASSWORD  = "password";
    }
    public static ContentValues UserToContentValues(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.UserConst.USER_NAME,user.getUserName());
        contentValues.put(Constants.UserConst.PASSWORD,user.getPassword());
        return contentValues;
    }

    public static User ContentValuesToUser(ContentValues contentValues) {
        User user= new User();
        user.setUserName(contentValues.getAsString(Constants.UserConst.USER_NAME));
        user.setPassword(contentValues.getAsString(Constants.UserConst.PASSWORD));
        return user;
    }
    public static ContentValues AddressToContentValues(Address address){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.AddressConst.CITY,address.getCity());
        contentValues.put(Constants.AddressConst.STREET,address.getStreet());
        contentValues.put(Constants.AddressConst.NUMBER,address.getNumber());
        return contentValues;
    }
    public static Address ContentValuesToAddress(ContentValues contentValues) {
        Address address = new Address();
        address.setCity(contentValues.getAsString(Constants.AddressConst.CITY));
        address.setStreet(contentValues.getAsString(Constants.AddressConst.STREET));
        address.setNumber(contentValues.getAsInteger(Constants.AddressConst.NUMBER));
        return address;
    }

    public static ContentValues BranchToContentValues(Branch branch){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.BranchConst.ADDRESS,branch.getAddress().toString());//what to do when the tipe isnt simple?
        contentValues.put(Constants.BranchConst.NUM_OF_PARKING_SPACES,branch.getNumOfParkingSpaces());
        contentValues.put(Constants.BranchConst.NUM_BRANCH,branch.getNumBranch());
        return contentValues;
    }
    public static Branch ContentValuesToBranch(ContentValues contentValues) {
        Branch branch = new Branch();
        branch.setAddress(contentValues.getAsAddress(Constants.BranchConst.ADDRESS));
        branch.setNumOfParkingSpaces(contentValues.getAsInteger(Constants.BranchConst.NUM_OF_PARKING_SPACES));
        branch.setNumBranch(contentValues.getAsInteger(Constants.BranchConst.NUM_BRANCH));
        return branch;}

    public static ContentValues CarToContentValues(Car car){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.CarConst.BRANCH_NUM,car.getBranchNum());
        contentValues.put(Constants.CarConst.CAR_MODEL,car.getCarModel().toString());//car.getCarModel()//what to do when the tipe isnt simple?
        contentValues.put(Constants.CarConst.KILOMATERS,car.getKilometers());
        contentValues.put(Constants.CarConst.CAR_NUM,car.getCarNum());
        return contentValues;
    }
    public static Car ContentValuesToCar(ContentValues contentValues) {
        Car car = new Car();
        car.setBranchNum(contentValues.getAsInteger(Constants.CarConst.BRANCH_NUM));
        car.setCarModel(contentValues.getAsCarModel(Constants.CarConst.CAR_MODEL));
        car.setKilometers(contentValues.getAsInteger(Constants.CarConst.KILOMATERS));
        car.setCarNum(contentValues.getAsInteger(Constants.CarConst.CAR_NUM));
        return car;
    }

    public static ContentValues CarModelToContentValues(CarModel carModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.CarModelConst.MODEL_CODE, carModel.getModelCode());
        contentValues.put(Constants.CarModelConst.COMPANY_NAME, carModel.getCompanyName());
        contentValues.put(Constants.CarModelConst.MODEL_NAME, carModel.getModelName());
        contentValues.put(Constants.CarModelConst.ENGINE_CAPACITY, carModel.getEngineCapacity());
        contentValues.put(Constants.CarModelConst.GEARBOX, carModel.getGearbox().toString());
        contentValues.put(Constants.CarModelConst.SEATS, carModel.getSeats());
        return contentValues;
    }
    public static CarModel ContentValuesToCarModel(ContentValues contentValues) {
        CarModel carModel = new CarModel();
        carModel.setModelCode(contentValues.getAsInteger(Constants.CarModelConst.MODEL_CODE));
        carModel.setCompanyName(contentValues.getAsString(Constants.CarModelConst.COMPANY_NAME));
        carModel.setModelName(contentValues.getAsString(Constants.CarModelConst.MODEL_NAME));
        carModel.setEngineCapacity(contentValues.getAsFloat(Constants.CarModelConst.ENGINE_CAPACITY));
        carModel.setGearbox(contentValues.getAsGearbox(Constants.CarModelConst.GEARBOX));
        carModel.setSeats(contentValues.getAsInteger(Constants.CarModelConst.SEATS));
        return carModel;}

public static ContentValues CustomerToContentValues(Customer customer) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.CustomerConst.FAMILY_NAME, customer.getFamilyName());
        contentValues.put(Constants.CustomerConst.PRIVATE_NAME, customer.getPrivateName());
        contentValues.put(Constants.CustomerConst.ID_NUM, customer.getIdNum());
        contentValues.put(Constants.CustomerConst.PHONE_NUM, customer.getPhoneNum());
        contentValues.put(Constants.CustomerConst.ADDRESS_MAIL, customer.getAddressMail());
        contentValues.put(Constants.CustomerConst.CREDIT_NUM, customer.getCreditNum());
        return contentValues;
        }

public static Customer ContentValuesToCustomer(ContentValues contentValues) {
        Customer customer = new Customer();
        customer.setFamilyName(contentValues.getAsString(Constants.CustomerConst.FAMILY_NAME));
        customer.setPrivateName(contentValues.getAsString(Constants.CustomerConst.PRIVATE_NAME));
        customer.setIdNum(contentValues.getAsInteger(Constants.CustomerConst.ID_NUM));
        customer.setPhoneNum(contentValues.getAsInteger(Constants.CustomerConst.PHONE_NUM));
        customer.setAddressMail(contentValues.getAsString(Constants.CustomerConst.ADDRESS_MAIL));
        customer.setCreditNum(contentValues.getAsInteger(Constants.CustomerConst.CREDIT_NUM));
        return customer;}

}
