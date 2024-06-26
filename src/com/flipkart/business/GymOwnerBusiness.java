package com.flipkart.business;

import com.flipkart.business.interfaces.IGymOwner;

public class GymOwnerBusiness implements IGymOwner {
    public boolean addCentre() {
        System.out.println("Centre added:> ");
        return true;
    }
    public void viewCentres() {
        System.out.println("Centres listed:> ");
    }
    public void viewFlipFitCustomers() {
        System.out.println("Flip fit customers:> ");
    }
    public void viewPayments() {
        System.out.println("Payments listed:> ");
    }
    public boolean editDetails() {
        System.out.println("Details edited:> ");
        return true;
    }
}
