package com.flipkart.business;
import com.flipkart.dao.FlipFitBookingDAOImpl;
public class BookingsBusiness {
    public void makeBooking(int slotId, int userId) {
        System.out.println("Making a booking for " + userId);

        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        bookingDAO.makeBooking();
    }

    public boolean deleteBooking(String userID, String slot) {
        System.out.println("Deleting a booking for " + userID);
        return true;
    }
}
