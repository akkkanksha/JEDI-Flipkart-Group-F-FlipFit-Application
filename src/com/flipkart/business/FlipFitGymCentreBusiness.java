package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.business.interfaces.IFlipFitGymCentre;
import com.flipkart.dao.FlipFitGymCentreDAOImpl;
import com.flipkart.dao.FlipFitSlotDAOImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipFitGymCentreBusiness implements IFlipFitGymCentre {
    List<FlipFitGymCentre> gymCentreList = new ArrayList<FlipFitGymCentre>();

    public void createGymCentre(){
        System.out.println("Creating Gym Centre:> ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Owner ID: ");
        int ownerID = scanner.nextInt();
        System.out.println("Enter Capacity: ");
        int capacity = scanner.nextInt();
        boolean approved = false;
        System.out.println("Enter City: ");
        String city = scanner.next();
        System.out.println("Enter State: ");
        String state = scanner.next();
        System.out.println("Enter Pincode: ");
        String pincode = scanner.next();

        FlipFitGymCentreDAOImpl gymCentreDAO = new FlipFitGymCentreDAOImpl();
        FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();

        flipFitGymCentre.setOwnerID(ownerID);
        flipFitGymCentre.setCapacity(capacity);
        flipFitGymCentre.setCity(city);
        flipFitGymCentre.setState(state);
        flipFitGymCentre.setPincode(pincode);
        flipFitGymCentre.setApproved(approved);
        gymCentreDAO.createGymCentre(flipFitGymCentre);
        System.out.println("Gym Centre created successfully.");
    }

    public boolean updateGymCentre(int centreID){
        System.out.println("Updating Gym Centre:> ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Updated Capacity: ");
        int capacity = scanner.nextInt();
        boolean approved = false;
        System.out.println("Enter Updated City: ");
        String city = scanner.next();
        System.out.println("Enter Updated State: ");
        String state = scanner.next();
        System.out.println("Enter Updated Pincode: ");
        String pincode = scanner.next();
        FlipFitGymCentreDAOImpl gymCentreDAO = new FlipFitGymCentreDAOImpl();
        FlipFitGymCentre flipFitGymCentre = gymCentreDAO.getGymCentreDetailsByID(centreID);
        flipFitGymCentre.setCapacity(capacity);
        flipFitGymCentre.setCity(city);
        flipFitGymCentre.setState(state);
        flipFitGymCentre.setPincode(pincode);
        flipFitGymCentre.setApproved(approved);
        gymCentreDAO.updateGymCentre(flipFitGymCentre);
        return true;
    }

    public boolean deleteGymCentre(int centreId){
        System.out.println("Deleting Gym Centre:> ");
        FlipFitGymCentreDAOImpl gymCentreDAO = new FlipFitGymCentreDAOImpl();
        FlipFitGymCentre flipFitGymCentre = gymCentreDAO.getGymCentreDetailsByID(centreId);
        gymCentreDAO.deleteGymCentre(flipFitGymCentre);
        return true;
    }

    public List<FlipFitSlots> viewAvailableSlots(int centreId) {
        System.out.println("Viewing Available Slots:> ");
        FlipFitSlotDAOImpl slotDAO = new FlipFitSlotDAOImpl();
        FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();
        flipFitGymCentre.setCentreID(centreId);
        return slotDAO.viewAvailableSlots(flipFitGymCentre);
    }
}
