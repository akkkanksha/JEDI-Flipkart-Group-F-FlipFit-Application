package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.business.interfaces.IFlipFitGymCentre;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymCentreBusiness implements IFlipFitGymCentre {
    List<FlipFitGymCentre> gymCentreList = new ArrayList<FlipFitGymCentre>();

    public void createGymCentre(){

        System.out.println("Creating Gym Centre:> ");
    }

    public boolean updateGymCentre(){
        System.out.println("Updating Gym Centre:> ");
        return true;
    }

    public boolean deleteGymCentre(int centreId){
        System.out.println("Deleting Gym Centre:> ");
        return true;
    }

    public List<FlipFitSlots> viewAvailableSlots(int centreId) {
        System.out.println("Viewing Available Slots:> ");
        return null;
    }
}
