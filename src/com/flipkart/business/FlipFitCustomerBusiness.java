package com.flipkart.business;

public class FlipFitCustomerBusiness {
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
