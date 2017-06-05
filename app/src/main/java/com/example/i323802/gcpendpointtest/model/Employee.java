package com.example.i323802.gcpendpointtest.model;

import org.json.JSONObject;

/**
 * Created by Deepankar on 6/5/2017.
 */

public class Employee {

    public static final String ADDRESS = "address";
    public static final String DEPARTMENT = "department";
    public static final String EMP_ID = "empId";
    public static final String NAME = "name";
    public static final String PHONE_NUMBER = "phoneNumber";

    private String address;
    private String department;
    private Long empId;
    private String name;
    private String phoneNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee(JSONObject elem) {
        try {
            this.address = elem.getString(ADDRESS);
            this.department = elem.getString(DEPARTMENT);
            this.empId = elem.getLong(EMP_ID);
            this.name = elem.getString(NAME);
            this.phoneNumber = elem.getString(PHONE_NUMBER);
        } catch(Exception e) {
            //do nothing
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nDepartment: " + department + "\nEmployee ID: " + empId.toString()
                + "\nAddress: " + address + "\nPhone Number: " + phoneNumber;
    }
}
