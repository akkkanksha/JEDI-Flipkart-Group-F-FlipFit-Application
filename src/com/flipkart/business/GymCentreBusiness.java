package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.business.interfaces.IGymCentre;
import java.util.ArrayList;
import java.util.List;

public class GymCentreBusiness implements IGymCentre {
    List<GymCentre> gymCentreList = new ArrayList<GymCentre>();
    private String centreID;
    private String ownerID;
    private ArrayList<String> slots;
    private int capacity;
    private boolean approved;
    private String city;
    private String state;
    private String pincode;
    public void createGymCentre(String ownerID, ArrayList<String>slots,String city, String state, String pincode, int capacity, boolean approved){
        int centerSize = gymCentreList.size();
        GymCentre newGymCentre = new GymCentre();
        newGymCentre.setOwnerID(ownerID);
        newGymCentre.setSlots(slots);
        newGymCentre.setCity(city);
        newGymCentre.setState(state);
        newGymCentre.setPincode(pincode);
        newGymCentre.setCapacity(capacity);
        newGymCentre.setApproved(approved);




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

    public void viewAvailableSlots() {
        System.out.println("Viewing Available Slots:> ");
    }
}
