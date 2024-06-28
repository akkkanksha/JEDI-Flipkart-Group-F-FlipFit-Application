package com.flipkart.business;
import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.dao.FlipFitBookingDAOImpl;
import com.flipkart.dao.FlipFitSlotDAOImpl;

import java.util.Random;

public class BookingsBusiness {
    public void makeBooking(int slotId, int userId) {

        //TODO:  Check if seat available > 0
        System.out.println("Making a booking for " + userId);

        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        FlipFitBooking booking = new FlipFitBooking();
        booking.setUserId(new Random().nextInt(100));
        booking.setSlotId(slotId);
        booking.setUserId(userId);
        booking.setIsdeleted(false);
        bookingDAO.makeBooking(booking);
        System.out.println("Booking completed");

        FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
        FlipFitSlots flipFitSlots = flipFitSlotDAO.getSlotDetailsById(slotId);
        FlipFitSlots currflipFitSlots = flipFitSlots;
        currflipFitSlots.setSeatsAvailable(flipFitSlots.getSeatsAvailable()-1);
        flipFitSlotsBusiness.updateAvailability(currflipFitSlots);
    }

    public boolean deleteBooking(int bookingId) {
        System.out.println("Deleting a booking for " + bookingId);
        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        bookingDAO.deleteBooking(bookingId);
//        int slotId = getBookingDetails(bookingId).g
        int slotId = 1;
        System.out.println("Booking deleted");
        FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
        FlipFitSlots flipFitSlots = flipFitSlotDAO.getSlotDetailsById(slotId);
        FlipFitSlots currflipFitSlots = flipFitSlots;
        currflipFitSlots.setSeatsAvailable(flipFitSlots.getSeatsAvailable()+1);
        flipFitSlotsBusiness.updateAvailability(currflipFitSlots);
        return true;
    }
}
