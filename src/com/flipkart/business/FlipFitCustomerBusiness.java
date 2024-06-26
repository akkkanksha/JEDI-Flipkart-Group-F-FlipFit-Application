package com.flipkart.business;

public class FlipFitCustomerBusiness {
	public void viewBookedSlots(int userId) {
		System.out.println("Here are all the slots that you booked for today -->");
    }
    public void checkBookingConflicts(int userId, int startTime) {
		System.out.println("Checking any conflicts -->");	
    }
    public void viewCentres(int userId) {
		System.out.println("Here are all the centres available in your city -->");	    	
    }
    public void makePayment(int userId) {
		System.out.println("Here are the details of the payment you made -->");	
    }
    public void editDetails(int userId) {
		System.out.println("Enter the updated details -->");	
    }
}
