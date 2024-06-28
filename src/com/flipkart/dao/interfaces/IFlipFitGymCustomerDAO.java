package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.bean.FlipFitUser;
import java.util.List;

public interface IFlipFitGymCustomerDAO {
//    public List<FlipFitSlots> viewBookedSlots(int userID);
//    public boolean checkBookingConflicts(int userID, int slotID);
//    public boolean makePayment(int userID);
//    public void viewPaymentDetails(int userID);
//    public void editPaymentDetails(int userID);
    public List<FlipFitGymCustomer> getUserList();

    public boolean editDetails(FlipFitGymCustomer customer);
    public List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre centre);

}