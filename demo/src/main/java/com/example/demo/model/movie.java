package com.example.demo.model;

public class movie {
    private String name;
    private String gender;
    private String duration;
    private String objectType;
    private String clasification;
    private String email;

    public movie() {
    }

    public movie(String name, String gender, String duration, String objectType, String clasification, String email) {
        this.name = name;
        this.gender = gender;
        this.duration = duration;
        this.objectType = objectType;
        this.clasification = clasification;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getClasification() {
        return clasification;
    }

    public void setClasification(String clasification) {
        this.clasification = clasification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
