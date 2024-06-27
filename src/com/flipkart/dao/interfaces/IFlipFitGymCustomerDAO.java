package com.flipkart.dao.interfaces;

public interface IFlipFitGymCustomerDAO {
    public void registerCustomer();
    public void viewBookedSlots(int userId);
    public boolean checkBookingConflicts(int userId, String slot);
    public void viewCentres();
    public boolean makePayment(int userId);
    public boolean editDetails(int userId);
}
