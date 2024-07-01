package com.flipkart.client;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitAdminBusiness;
import com.flipkart.business.FlipFitGymCentreBusiness;
import com.flipkart.business.FlipFitGymOwnerBusiness;
import com.flipkart.dao.FlipFitAdminDAOImpl;
import com.flipkart.dao.FlipFitGymCentreDAOImpl;
import com.flipkart.dao.FlipFitGymCustomerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;
import com.flipkart.exceptions.InvalidChoiceException;

import java.util.List;
import java.util.Scanner;

public class GymFlipFitOwnerMenu {
    public static void getFlipFitOwnerView(FlipFitUser gymOwner) throws InvalidChoiceException {
        try {
            FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();
            FlipFitGymOwnerBusiness GOBservice = new FlipFitGymOwnerBusiness(flipFitGymOwnerDAO);
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("Gym Owner Menu:> ");
                System.out.println("Choose an option:" +
                        "\n 1. Add Centre" +
                        "\n 2. View Centres" +
                        "\n 3. Logout");
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Give details to add Centre : ");
                        Scanner scanner = new Scanner(System.in);
                        int ownerID = gymOwner.getUserID();
                        System.out.println("Enter Capacity: ");
                        int capacity = scanner.nextInt();
                        System.out.println("Enter City: ");
                        String city = scanner.next();
                        System.out.println("Enter State: ");
                        String state = scanner.next();
                        System.out.println("Enter Pincode: ");
                        String pincode = scanner.next();

//                        FlipFitAdminDAOImpl adminDAO = new FlipFitAdminDAOImpl();
//                        FlipFitAdminBusiness flipFitAdminBusiness = new FlipFitAdminBusiness(adminDAO);
//                        boolean approved = flipFitAdminBusiness.validateOwner(ownerID);

                        FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();

                        flipFitGymCentre.setOwnerID(ownerID);
                        flipFitGymCentre.setCapacity(capacity);
                        flipFitGymCentre.setCity(city);
                        flipFitGymCentre.setState(state);
                        flipFitGymCentre.setPincode(pincode);
                        flipFitGymCentre.setApproved(true);

                        GOBservice.addCentre(flipFitGymCentre);

                        System.out.println("Gym Centre created successfully.");
                        break;
                    }
                    case 2: {
                        System.out.println("View Centres for the owner : " + gymOwner.getUserID());
                        FlipFitGymOwner flipFitGymOwner = new FlipFitGymOwner();
                        flipFitGymOwner.setUserId(gymOwner.getUserID());
                        List<FlipFitGymCentre> centreList = GOBservice.viewCentres(flipFitGymOwner);
                        for (FlipFitGymCentre centre : centreList) {
                            System.out.println("CentreID : " + centre.getCentreID() + " Capacity : " + centre.getCapacity() + " City : " + centre.getCity() + " State : " + centre.getState());
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Successful logout");
                    }
                    default: {
                        throw new InvalidChoiceException("Invalid choice entered: " + choice);
                    }
                }
            }
            while (choice != 4);
        } catch (InvalidChoiceException e) {
            System.out.println(e.getMessage());
        }
    }
}
