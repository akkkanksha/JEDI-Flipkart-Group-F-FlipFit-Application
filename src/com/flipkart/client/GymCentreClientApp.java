package com.flipkart.client;

import com.flipkart.business.GymCentreBusiness;

public class GymCentreClientApp {
    public static void main(String[] args) {
        GymCentreBusiness GCBservice = new GymCentreBusiness();
        GCBservice.createGymCentre();
        System.out.println("Update Gym Centre" + GCBservice.updateGymCentre());
        System.out.println("Delete Gym Centre" + GCBservice.deleteGymCentre());
        GCBservice.listGymCentres();
        GCBservice.viewAvailableSlots();
    }
}
