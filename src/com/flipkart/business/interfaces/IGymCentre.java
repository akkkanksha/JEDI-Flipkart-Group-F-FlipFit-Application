package com.flipkart.business.interfaces;

public interface IGymCentre {
    public void createGym(String gymName);
    public boolean updateGymCentre()

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
