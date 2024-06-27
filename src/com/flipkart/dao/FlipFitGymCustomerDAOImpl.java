package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.dao.interfaces.IFlipFitGymCustomerDAO;

public class FlipFitGymCustomerDAOImpl implements IFlipFitGymCustomerDAO {

    @Override
    public void registerCustomer(FlipFitGymCustomer flipFitGymCustomer) {

    }

    @Override
    public void viewBookedSlots(int userId) {

    }

    @Override
    public boolean checkBookingConflicts(int userId, String slot) {
        return false;
    }

    @Override
    public void viewCentres() {

    }

    @Override
    public boolean makePayment(int userId) {
        return false;
    }

    @Override
    public void editDetails(FlipFitGymCustomer flipFitGymCustomer) {

    }
}
