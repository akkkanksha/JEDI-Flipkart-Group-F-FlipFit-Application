package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.business.interfaces.IFlipFitGymCentre;
import com.flipkart.dao.FlipFitGymCentreDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymCentreBusiness implements IFlipFitGymCentre {
    List<FlipFitGymCentre> gymCentreList = new ArrayList<FlipFitGymCentre>();

    public void createGymCentre(){
        System.out.println("Creating Gym Centre:> ");
        FlipFitGymCentreDAOImpl gymCentreDAO = new FlipFitGymCentreDAOImpl();

        FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();

        gymCentreDAO.createGymCentre(flipFitGymCentre);
    }

    public boolean updateGymCentre(){
        System.out.println("Updating Gym Centre:> ");
        FlipFitGymCentreDAOImpl gymCentreDAO = new FlipFitGymCentreDAOImpl();
        FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();
        gymCentreDAO.updateGymCentre(flipFitGymCentre);
        return true;
    }

    public boolean deleteGymCentre(int centreId){
        System.out.println("Deleting Gym Centre:> ");
        FlipFitGymCentreDAOImpl gymCentreDAO = new FlipFitGymCentreDAOImpl();
        FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();
        gymCentreDAO.deleteGymCentre(flipFitGymCentre);
        return true;
    }

    public List<FlipFitSlots> viewAvailableSlots(int centreId) {
        System.out.println("Viewing Available Slots:> ");
        FlipFitGymCentreDAOImpl gymCentreDAO = new FlipFitGymCentreDAOImpl();

        FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();
        flipFitGymCentre.setCentreID(centreId);
        return gymCentreDAO.viewAvailableSlots(flipFitGymCentre);
    }
}
