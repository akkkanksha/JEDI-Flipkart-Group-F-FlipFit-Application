package com.flipkart.dao;

import com.flipkart.dao.interfaces.IFlipFitGymCustomerDAO;

public class FlipFitGymCustomerDAOImpl implements IFlipFitGymCustomerDAO {


    @Override
    public void viewBookedSlots(int userId) {

    }

    @Override
    public boolean checkBookingConflicts(int userID, String slot) {
        return false;
    }

    @Override
    public void viewCentres() {

    }

    @Override
    public boolean makePayment(int userID) {
        return false;
    }

    @Override
    public void viewPaymentDetails(int userID) {

    }

    @Override
    public void editPaymentDetails(int userID) {

    }

    @Override
    public boolean editDetails(int userId) {
        return false;
    }
}
