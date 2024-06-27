package com.flipkart.business;
import com.flipkart.bean.*;
import com.flipkart.business.interfaces.IFlipFitGymCustomer;
public class FlipFitGymCustomerBusiness implements  IFlipFitGymCustomer {

    public void registerCustomer(String username) {
        System.out.println("Registering Customer " + username);
    }


	public void viewBookedSlots(int userId) {
        System.out.println("Viewing booked slots:> ");
    }
    public boolean checkBookingConflicts(int userId, String slot) {
        System.out.println("Checking conflict for slot " + slot);
        return true;
    }
    public void viewCentres() {
        System.out.println("view centres called:> ");
    }
    public boolean makePayment(int userId) {
        System.out.println("Make payment called:> ");
        return true;
    }
    public boolean editDetails(int userId) {
        System.out.println("Edit details called:> ");
        return true;
    }
}
