package com.flipkart.business;
import com.flipkart.dao.FlipFitGymCustomerDAOImpl;
import com.flipkart.dao.interfaces.IFlipFitBookingDAO;
import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.dao.FlipFitBookingDAOImpl;
import com.flipkart.dao.FlipFitSlotDAOImpl;

public class BookingsBusiness {
    private final IFlipFitBookingDAO bookingDAO ;
    public BookingsBusiness(FlipFitBookingDAOImpl FFBooking){
        this.bookingDAO=FFBooking;
    }

    public FlipFitBooking makeBooking(int userID, int centreID, int startTime) {

//        System.out.println("Making a booking for " + userID);
        FlipFitSlotDAOImpl slotDAO=new FlipFitSlotDAOImpl();
        FlipFitSlots slotdetails = slotDAO.getSlotDetails(startTime, centreID);

        FlipFitGymCustomerDAOImpl FFGymCustomer = new FlipFitGymCustomerDAOImpl();
        FlipFitGymCustomerBusiness flipFitGymCustomerBusiness = new FlipFitGymCustomerBusiness(FFGymCustomer);
        if(slotdetails!=null && slotdetails.getSeatsAvailable() > 0) {
            FlipFitBooking booking = flipFitGymCustomerBusiness.checkBookingConflicts(userID, startTime);
            if(booking != null) {
                deleteBooking(booking.getBookingId());
            }
            booking = new FlipFitBooking();
            booking.setSlotId(slotdetails.getSlotId());
            booking.setSlotTime(slotdetails.getSlotTime());
            booking.setUserId(userID);
            booking.setIsdeleted(false);

            bookingDAO.makeBooking(booking);
//            System.out.println("Booking completed");

//            FlipFitSlots currflipFitSlots = slotdetails;

            int seatsAvailable = slotdetails.getSeatsAvailable();
            slotdetails.setSeatsAvailable(seatsAvailable - 1);

            FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
            flipFitSlotsBusiness.updateAvailability(slotdetails);
            return booking;
        }
        return null;
    }

    public boolean deleteBooking(int bookingId) {
//        System.out.println("Deleting a booking for " + bookingId);
        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        FlipFitBooking bookingDetails = bookingDAO.getBookingDetailsByBookingId(bookingId);
        if(bookingDetails==null) {
            return false;
        }
        int slotId = bookingDetails.getSlotId();
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
        FlipFitSlots flipFitSlots = flipFitSlotDAO.getSlotDetailsById(slotId);
        if(flipFitSlots != null) {
            int seatsAvailable = flipFitSlots.getSeatsAvailable();
            flipFitSlots.setSeatsAvailable(seatsAvailable+1);

            FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
            flipFitSlotsBusiness.updateAvailability(flipFitSlots);

        }

        bookingDAO.deleteBooking(bookingId);
        return true;
    }
}
