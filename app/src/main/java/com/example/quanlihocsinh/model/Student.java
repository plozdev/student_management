package com.example.quanlihocsinh.model;


import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Student implements Serializable {

    @Exclude
    private String key;
    private String name;
    private String major;
    private String gender;
    private String phone;
    private String gmail;

    public Student(){}
    public Student(String name, String major, String gender, String phone, String gmail) {
        this.name = name;
        this.major = major;
        this.gender = gender;
        this.phone = phone;
        this.gmail = gmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
