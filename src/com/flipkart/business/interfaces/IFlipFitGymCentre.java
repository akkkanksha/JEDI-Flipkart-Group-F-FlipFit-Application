package com.flipkart.business.interfaces;

public interface IFlipFitGymCentre {
    public void createGymCentre(String centreCity, String centreCapacity, String centreState,String centreZipCode, String slotsTiming);
    public boolean updateGymCentre(String CentreId);
    public boolean deleteGymCentre(String CentreId);
    public boolean viewGymCentre(String city);
    public boolean viewAllGymCentresByOwnerId(String OwnerId);
    public void viewAvailableSlots(String CentreId);
}
