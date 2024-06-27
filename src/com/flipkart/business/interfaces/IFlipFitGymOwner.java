package com.flipkart.business.interfaces;

public interface IFlipFitGymOwner {
    public boolean addCentre();
    public void viewCentres();
    public void viewFlipFitCustomers(String OwnerId);
    public void viewPayments();
    public boolean editDetails(String OwnerId);
}
