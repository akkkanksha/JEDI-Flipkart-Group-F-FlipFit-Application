package com.flipkart.business;

public class BookingsBusiness {
    public void makeBooking(String userID) {
        System.out.println("Making a booking for " + userID);
    }

    public boolean deleteBooking(String userID, String slot) {
        System.out.println("Deleting a booking for " + userID);
        return true;
    }
}
