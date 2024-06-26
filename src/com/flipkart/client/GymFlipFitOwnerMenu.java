package com.flipkart.client;

import com.flipkart.business.GymCentreBusiness;
import com.flipkart.business.GymOwnerBusiness;

public class GymFlipFitOwnerMenu {
    public static void getFlipFitOwnerMenu() {
        GymOwnerBusiness GOBservice = new GymOwnerBusiness();
        GOBservice.addCentre();
        GOBservice.viewCentres();
        GOBservice.viewFlipFitCustomers();
        GOBservice.viewPayments();
        System.out.println("Gym Owner details edited:> " + GOBservice.editDetails());
    }

    public static void getFlipFitCentreMenu() {
        // Gym Centre
        GymCentreBusiness GCBservice = new GymCentreBusiness();
        GCBservice.createGymCentre();
        // System.out.println("Update Gym Centre" + GCBservice.updateGymCentre());
        // System.out.println("Delete Gym Centre" + GCBservice.deleteGymCentre());
        GCBservice.viewAvailableSlots();
    }
}
