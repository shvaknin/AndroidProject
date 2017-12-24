package com.example.mailo.takengo.models.entities;

import java.io.Serializable;

/**
 * Created by USER on 19/11/2017.
 */

public class User implements Serializable {
    String userName;
    String password;

    public User() {//empty constructor
        this.userName = "";
        this.password = "";
    }
    /**
     * constructor
     * @param userName
     * @param password
     */

    public User(String userName, String password) {//parameter constructor
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userName.equals(user.userName)) return false;
        return password.equals(user.password);

    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
