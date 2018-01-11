package com.fox.automation.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UserAccount {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String gender;
    private String birthdateMonth;
    private String birthdateDay;
    private String birthdateYear;

    public static String generateDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd'T'HH-mm-ss");
        Random r = new Random();
        return dateFormat.format(new Date()) + "-" + String.format("%04d", r.nextInt(10000));
    }

    public static UserAccount generateUserAccount(String key) {
        UserAccount u = new UserAccount();
        u.setFirstname("F-"+key);
        u.setLastname("L-"+key);
        u.setEmail("email-"+key+"@test.com");
        u.setPassword("password-"+key);
        u.setGender("Male");
        u.setBirthdateMonth("01");
        u.setBirthdateDay("10");
        u.setBirthdateYear("2000");
        return u;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdateMonth() {
        return birthdateMonth;
    }

    public void setBirthdateMonth(String birthdateMonth) {
        this.birthdateMonth = birthdateMonth;
    }

    public String getBirthdateDay() {
        return birthdateDay;
    }

    public void setBirthdateDay(String birthdateDay) {
        this.birthdateDay = birthdateDay;
    }

    public String getBirthdateYear() {
        return birthdateYear;
    }

    public void setBirthdateYear(String birthdateYear) {
        this.birthdateYear = birthdateYear;
    }
}
