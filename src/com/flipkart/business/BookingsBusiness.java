package com.flipkart.business;

import com.flipkart.bean.FlipFitBooking;

public class BookingsBusiness {
    public void makeBooking(FlipFitBooking booking) {
        System.out.println("Making a booking for " + booking);
    }

    public boolean deleteBooking(boolean bookingId) {
        System.out.println("Deleting a booking for " + bookingId);
        return true;
    }
}
