package com.flipkart.business;
import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.dao.FlipFitBookingDAOImpl;
import com.flipkart.dao.FlipFitSlotDAOImpl;

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
        FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
        flipFitSlotsBusiness.updateAvailability(slotId);
    }

    public boolean deleteBooking(int bookingId) {
        System.out.println("Deleting a booking for " + bookingId);
        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        bookingDAO.deleteBooking(bookingId);
        return true;
    }
}
