package com.georgiancollege.test1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
    private int employeeID;



    private String firstName, lastName, address, city, province;
    private int phoneNo;


    public Employee(int employeeID, String firstName, String lastName, String address, String city, String province, int phoneNo) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.phoneNo = phoneNo;

    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        if(employeeID > 200465000) {
            this.employeeID = employeeID;
        }else{
            throw new IllegalArgumentException("Employee Id is out of range should be less than 200465000");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() > 1) {
            this.firstName = firstName;
        }else{
            throw new IllegalArgumentException("First Name must be more than 1 char");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() > 1) {
            this.lastName = lastName;
        }else{
            throw new IllegalArgumentException("last Name must be more than 1 char");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address.length() > 5) {
            this.address = address;
        }else{
            throw new IllegalArgumentException("address must be more than 5 char");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city.length() > 3) {
            this.city = city;
        }else{
            throw new IllegalArgumentException("city must be more than 3 char");
        }
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        List<String> vaildList = findProvince();
        if(vaildList.contains(province)) {
            this.province = province;
        }else{
            throw new IllegalArgumentException("The province should be in the vaild List" + vaildList);
        }
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        String regex = "[2-9]\\d{2}-[2-9]\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        String stringNo = Integer.toString(phoneNo);
        Matcher matcher = pattern.matcher(stringNo);
        if(matcher.matches()) {
            this.phoneNo = phoneNo;
        }else{
            throw new IllegalArgumentException("The input didn't match the format XXX-XXX-XXXX");
        }
    }

    public static List<String> findProvince(){
        String[] listOfProvince = {"AB","BC","MB","NB","NL","NS","NT","NU","ON","PE","QC","SK","YT"};
        return Arrays.asList(listOfProvince);
    }

}