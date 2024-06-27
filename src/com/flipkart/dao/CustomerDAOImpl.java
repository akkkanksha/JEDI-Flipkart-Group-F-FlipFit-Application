package com.flipkart.dao;

import com.flipkart.dao.interfaces.ICustomerDAO;

public class CustomerDAOImpl implements ICustomerDAO {

    @Override
    public void registerCustomer() {

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
    public boolean editDetails(int userId) {
        return false;
    }
}
