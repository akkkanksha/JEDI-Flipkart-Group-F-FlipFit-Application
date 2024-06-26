package com.flipkart.business.*;
public interface IFlipFitCustomer {
    public void viewBookedSlots(int userId);
    public boolean checkBookingConflicts(int userId, String slot);
    public void viewCentres();
    public boolean makePayment(int userId)
    public boolean editDetails(int userId);
}