package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.business.interfaces.IFlipFitGymCentre;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymCentreBusiness implements IFlipFitGymCentre {
    List<FlipFitGymCentre> gymCentreList = new ArrayList<FlipFitGymCentre>();
    private String centreID;
    private String ownerID;
    private ArrayList<String> slots;
    private int capacity;
    private boolean approved;
    private String city;
    private String state;
    private String pincode;


    public void createGymCentre(String centreCity, String centreCapacity, String centreState,String centreZipCode, String slotsTiming){
        System.out.println("Creating Gym Centre:> ");
    }

    public boolean updateGymCentre(String CentreId){
        System.out.println("Updating Gym Centre:> ");
        return true;
    }
    public boolean viewGymCentre(String city) {
        System.out.println("View Gym Centre:> ");
        return true;
    }
    public boolean viewAllGymCentres(String OwnerId) {
        System.out.println("View All Gym Centre:> ");
        return true;
    }
    public boolean deleteGymCentre(String CentreId){
        System.out.println("Deleting Gym Centre:> ");
        return true;
    }

    public void viewAvailableSlots(String centreID) {

        System.out.println("Viewing Available Slots:> ");
    }
}
