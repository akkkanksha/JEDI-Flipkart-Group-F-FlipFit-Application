package com.flipkart.business.interfaces;
public interface IFlipFitGymCustomer {
    public void viewBookedSlots(int userId);
    public boolean checkBookingConflicts(int userId, int slodId);
    public void viewCentres();
    public boolean makePayment(int userId);
    public boolean editDetails(int userId);
}
