package com.example.mailo.takengo.models.entities;

/**
 * Created by USER on 19/11/2017.
 */

public class Customer {
        String Name;
        String privateName;
        int idNum;
        int phoneNum;
        String addressMail;
        int creditNum;

        public Customer() {//empty constructor
        this.familyName = "";
        this.privateName ="" ;
        this.idNum =0 ;
        this.phoneNum =0 ;
        this.addressMail = "";
        this.creditNum =0 ;
    }
        /**
         *constructor
         * @param familyName
         * @param privateName
         * @param idNum
         * @param phoneNum
         * @param addressMail
         * @param creditNum
         */

        public Customer(String familyName, String privateName, int idNum, int phoneNum, String addressMail, int creditNum) {//parameter constructor
            this.familyName = familyName;
            this.privateName = privateName;
            this.idNum = idNum;
            this.phoneNum = phoneNum;
            this.addressMail = addressMail;
            this.creditNum = creditNum;
        }

        /**
         *Getter & Setter
         */

        public String getFamilyName() {
            return familyName;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }

        public String getPrivateName() {
            return privateName;
        }

        public void setPrivateName(String privateName) {
            this.privateName = privateName;
        }

        public int getIdNum() {
            return idNum;
        }

        public void setIdNum(int idNum) {
            this.idNum = idNum;
        }

        public int getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(int phoneNum) {
            this.phoneNum = phoneNum;
        }

        public String getAddressMail() {
            return addressMail;
        }

        public void setAddressMail(String addressMail) {
            this.addressMail = addressMail;
        }

        public int getCreditNum() {
            return creditNum;
        }

        public void setCreditNum(int creditNum) {
            this.creditNum = creditNum;
        }
    }
