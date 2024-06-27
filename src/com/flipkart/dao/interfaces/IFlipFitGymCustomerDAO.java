package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCustomer;

public interface IFlipFitGymCustomerDAO {

    public FlipFitGymCustomer registerCustomer(String username, String password, String emailID, String phoneNumber, String city, String pinCode, int role);
    public boolean checkBookingConflicts(int userId, String slot);

    public boolean makePayment(int userId);
    public FlipFitGymCustomer editDetails(int userId);
}
