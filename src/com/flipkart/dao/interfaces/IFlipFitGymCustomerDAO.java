package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCustomer;

public interface IFlipFitGymCustomerDAO {

    public void registerCustomer(FlipFitGymCustomer flipFitGymCustomer);
    public boolean checkBookingConflicts(int userId, String slot);

    public void viewBookedSlots(int userId);
    public boolean makePayment(int userId);
    public void editDetails(FlipFitGymCustomer flipFitGymCustomer);
}
