package com.flipkart.business.interfaces;

import com.flipkart.exceptions.InvalidChoiceException;

public interface IFlipFitGymOwner {
    public boolean addCentre();
    public void viewCentres();
    public void viewFlipFitCustomers();
    public void viewPayments();
    public boolean editDetails() throws InvalidChoiceException;
}
