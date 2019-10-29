package com.example.manuapp;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String number;
    private String position;
    private String url;
    private String image;
    private String country;
    private String countryImage;
    private String joinedDate;
    private String dateOfBirth;
    private String debutDate;
    private String age;
    private String appearances;
    private String cleanSheet;
    private String goals;

    public Player(String name, String number, String position, String image, String url,String country,
                  String countryImage, String joinedDate, String dateOfBirth,String debutDate, String age,
                  String appearances, String cleanSheet, String goals) {
        this.name = name;
        this.number=number;
        this.position = position;
        this.image = image;
        this.country = country;
        this.countryImage = countryImage;
        this.joinedDate = joinedDate;
        this.dateOfBirth = dateOfBirth;
        this.debutDate = debutDate;
        this.url = url;
        this.age = age;
        this.appearances =appearances;
        this.cleanSheet =cleanSheet;
        this.goals=goals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryImage() {
        return countryImage;
    }

    public void setCountryImage(String countryImage) {
        this.countryImage = countryImage;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(String debutDate) {
        this.debutDate = debutDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAppearances() {
        return appearances;
    }

    public void setAppearances(String appearances) {
        this.appearances = appearances;
    }

    public String getCleanSheet() {
        return cleanSheet;
    }

    public void setCleanSheet(String cleanSheet) {
        this.cleanSheet = cleanSheet;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }
}
