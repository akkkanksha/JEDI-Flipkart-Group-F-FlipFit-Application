package com.flipkart.dao.interfaces;

public interface IFlipFitGymCustomerDAO {
    public void viewBookedSlots(int userID);
    public boolean checkBookingConflicts(int userID, String slot);
    public void viewCentres();
    public boolean makePayment(int userID);
    public void viewPaymentDetails(int userID);
    public void editPaymentDetails(int userID);
    public boolean editDetails(int userID);
}
