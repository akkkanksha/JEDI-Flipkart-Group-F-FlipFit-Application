package com.flipkart.business;
import com.flipkart.bean.*;
import com.flipkart.business.interfaces.IFlipFitGymCustomer;
import java.util.List;
import com.flipkart.dao.FlipFitBookingDAOImpl;
import com.flipkart.dao.FlipFitSlotDAOImpl;

public class FlipFitGymCustomerBusiness implements  IFlipFitGymCustomer {

    private int UserId;

    public void registerCustomer(String username) {
        System.out.println("Registering Customer " + username);
    }


    @Override
    public void viewBookedSlots(int userId) {

        System.out.println("Viewing booked slots:> ");
        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        FlipFitSlotDAOImpl slotDAO = new FlipFitSlotDAOImpl();
        List<FlipFitBooking> bookingsList= bookingDAO.getAllBookings(UserId);
        for (FlipFitBooking booking : bookingsList) {
            FlipFitSlots slotdetails = slotDAO.getSlotDetailsById(booking.getSlotId());
            System.out.println("Booking ID: " + booking.getBookingId() + "Slot timing " + slotdetails.getSlotTime());
        }

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
