package com.flipkart.business;
import com.flipkart.bean.FlipFitBooking;
import com.flipkart.dao.FlipFitBookingDAOImpl;

import java.util.Random;

public class BookingsBusiness {
    public void makeBooking(int slotId, int userId) {
        System.out.println("Making a booking for " + userId);

        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        FlipFitBooking booking = new FlipFitBooking();
        booking.setUserId(new Random().nextInt(100));
        booking.setSlotId(slotId);
        booking.setUserId(userId);
        booking.setIsdeleted(false);
        bookingDAO.makeBooking(booking);
    }

    public boolean deleteBooking(String userID, String slot) {
        System.out.println("Deleting a booking for " + userID);
        return true;
    }
}
