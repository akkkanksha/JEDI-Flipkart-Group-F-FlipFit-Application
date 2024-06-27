package com.flipkart.bean;

import java.util.ArrayList;

public class FlipFitGymCentre {
    private int centreID;
    private int ownerID;
    private int capacity;
    private boolean approved;
    private String city;
    private String state;
    private String pincode;

    public int getCentreID() {
        return centreID;
    }

    public void setCentreID(int centreID) {
        this.centreID = centreID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

}
