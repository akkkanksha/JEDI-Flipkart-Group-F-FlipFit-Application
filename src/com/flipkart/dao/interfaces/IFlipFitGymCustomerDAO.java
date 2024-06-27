package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitSlots;

import java.util.List;

public interface IFlipFitGymCustomerDAO {
    public List<FlipFitSlots> viewBookedSlots(int userID);
    public boolean checkBookingConflicts(int userID, int slotID);
    public List<FlipFitGymCentre> viewCentres();
    public boolean makePayment(int userID);
    public void viewPaymentDetails(int userID);
    public void editPaymentDetails(int userID);
    public boolean editDetails(FlipFitGymCustomer customer);
}