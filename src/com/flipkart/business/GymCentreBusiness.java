package com.flipkart.business;

import com.flipkart.business.interfaces.IGymCentre;

public class GymCentreBusiness implements IGymCentre {
    public void createGymCentre(){
        System.out.println("Creating Gym Centre:> ");
    }

    public boolean updateGymCentre(){
        System.out.println("Updating Gym Centre:> ");
        return true;
    }

    public boolean deleteGymCentre(){
        System.out.println("Deleting Gym Centre:> ");
        return true;
    }

    public void listGymCentres(){
        System.out.println("Listing Gym Centres:> ");
    }

    public void viewAvailableSlots() {
        System.out.println("Viewing Available Slots:> ");
    }
}
