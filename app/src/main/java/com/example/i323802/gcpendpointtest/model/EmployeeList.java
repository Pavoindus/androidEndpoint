package com.example.i323802.gcpendpointtest.model;

/**
 * Created by Deepak on 6/5/2017.
 */

public class EmployeeList {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " : " + id;
    }
}
