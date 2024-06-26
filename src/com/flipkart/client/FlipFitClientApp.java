package com.flipkart.client;

import com.flipkart.bean.AdminUser;
import com.flipkart.business.*;

public class FlipFitClientApp {
    public static void main(String[] args) {

        // Gym Owner
        GymOwnerBusiness GOBservice = new GymOwnerBusiness();
        GOBservice.addCentre();
        GOBservice.viewCentres();
        GOBservice.viewFlipFitCustomers();
        GOBservice.viewPayments();
        System.out.println("Gym Owner details edited:> " + GOBservice.editDetails());

        // Customer
        FlipFitCustomerBusiness service = new FlipFitCustomerBusiness();
        int userId=101;
        String slot="6am-7am";
        service.viewBookedSlots(userId);
        service.checkBookingConflicts(userId, slot);
        service.viewCentres();
        service.makePayment(userId);
        service.editDetails(userId);

        // Admin


        // Bookings
        BookingsBusiness BBservice = new BookingsBusiness();
        String userID = "101";
        BBservice.makeBooking(userID);
        BBservice.deleteBooking(userID, slot);

        // Slots
        SlotsBusiness SBservice = new SlotsBusiness();
        SBservice.getSlotDetails();
        System.out.println("Update availability:> "+SBservice.updateAvailability());

        // Gym Centre
        GymCentreBusiness GCBservice = new GymCentreBusiness();
        GCBservice.createGymCentre();
        System.out.println("Update Gym Centre" + GCBservice.updateGymCentre());
        System.out.println("Delete Gym Centre" + GCBservice.deleteGymCentre());
        GCBservice.listGymCentres();
        GCBservice.viewAvailableSlots();
    }
}
