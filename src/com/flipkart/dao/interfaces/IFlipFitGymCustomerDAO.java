package com.flipkart.dao.interfaces;

import com.flipkart.bean.*;

import java.util.List;

public interface IFlipFitGymCustomerDAO {
    public List<FlipFitSlots> viewBookedSlots(int userID);
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime);
    public List<FlipFitGymCentre> viewCentres();
    public boolean makePayment(int userID);
    public void viewPaymentDetails(int userID);
    public void editPaymentDetails(int userID);
    public FlipFitUser addUser(FlipFitUser user);
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer customer);
    public FlipFitGymCustomer addCustomer(FlipFitGymCustomer customer, FlipFitUser user);
}