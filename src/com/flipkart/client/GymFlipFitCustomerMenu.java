package com.flipkart.client;

import com.flipkart.business.BookingsBusiness;
import com.flipkart.business.FlipFitGymCustomerBusiness;
import com.flipkart.business.FlipFitSlotsBusiness;
import com.flipkart.business.interfaces.IFlipFitSlots;

public class GymFlipFitCustomerMenu {
    public static String slot = "6am-7am";
    static FlipFitGymCustomerBusiness service = new FlipFitGymCustomerBusiness();
    static int userId = 101;

    public static void getFlipFitCustomerMenu() {
        service.viewBookedSlots(userId);
//        service.checkBookingConflicts(userId, slot);
        service.viewCentres();
//        service.makePayment(userId);
        service.editDetails(userId);
    }
    public static void getFlipFitBookingMenu() {
        BookingsBusiness BBservice = new BookingsBusiness();
        String userID = "101";
        BBservice.makeBooking(userID);
        BBservice.deleteBooking(userID, slot);
    }
    public static void getFlipFitSlotMenu() {
        // Slots
        FlipFitSlotsBusiness SBservice = new FlipFitSlotsBusiness();
        SBservice.getSlotDetails();
        System.out.println("Update availability:> " + SBservice.updateAvailability());
    }

}
