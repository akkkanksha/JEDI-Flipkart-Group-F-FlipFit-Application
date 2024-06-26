package com.flipkart.client;

import com.flipkart.business.BookingsBusiness;
import com.flipkart.business.FlipFitCustomerBusiness;
import com.flipkart.business.GymCentreBusiness;
import com.flipkart.business.SlotsBusiness;
import com.flipkart.business.interfaces.ISlots;

public class GymFlipFitCustomerMenu {
    public static String slot = "6am-7am";
    static FlipFitCustomerBusiness service = new FlipFitCustomerBusiness();
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
        ISlots SBservice = new SlotsBusiness();
        SBservice.getSlotDetails();
        System.out.println("Update availability:> " + SBservice.updateAvailability());
    }

}
