package com.flipkart.client;

import com.flipkart.bean.AdminUser;
import com.flipkart.business.AdminUserBusiness;
import com.flipkart.business.GymCentreBusiness;

public class FlipFitClientApp {
    public static void main(String[] args) {

        // Gym Owner

        // Customer

        // Admin

        // Bookings

        // Slots

        // Gym Centre
        GymCentreBusiness GCBservice = new GymCentreBusiness();
        GCBservice.createGymCentre();
        System.out.println("Update Gym Centre" + GCBservice.updateGymCentre());
        System.out.println("Delete Gym Centre" + GCBservice.deleteGymCentre());
        GCBservice.listGymCentres();
        GCBservice.viewAvailableSlots();
    }
}
