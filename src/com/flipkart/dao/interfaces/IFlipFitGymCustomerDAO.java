package com.flipkart.dao.interfaces;

import com.flipkart.bean.*;

import java.util.List;

public interface IFlipFitGymCustomerDAO {
//    public List<FlipFitSlots> viewBookedSlots(int userID);
//    public boolean checkBookingConflicts(int userID, int slotID);
//    public boolean makePayment(int userID);
//    public void viewPaymentDetails(int userID);
//    public void editPaymentDetails(int userID);

    public List<FlipFitGymCustomer> getUserList();
    public FlipFitGymCustomer createCustomer(FlipFitGymCustomer flipFitGymCustomer);
    public boolean editDetails(FlipFitGymCustomer customer);
    public List<FlipFitGymCustomer> viewFlipFitCustomersByCentre(FlipFitGymCentre centre);
    public List<FlipFitGymCustomer> viewFlipFitCustomersByOwner(FlipFitGymOwner owner);

}