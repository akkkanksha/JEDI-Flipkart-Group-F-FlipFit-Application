package com.flipkart.business.interfaces;

import com.flipkart.exceptions.InvalidChoiceException;

public interface IFlipFitGymCustomer {
    public void viewBookedSlots(int userId);
    public boolean checkBookingConflicts(int userId, int slodId);
    public void viewCentres();
    public boolean makePayment(int userId);
    public boolean editDetails(int userId) throws InvalidChoiceException;
}
