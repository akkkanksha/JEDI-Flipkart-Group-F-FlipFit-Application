package com.flipkart.client;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.business.FlipFitAdminBusiness;
import com.flipkart.business.FlipFitGymCentreBusiness;
import com.flipkart.business.FlipFitGymOwnerBusiness;
import com.flipkart.dao.FlipFitAdminDAOImpl;
import com.flipkart.dao.FlipFitGymCentreDAOImpl;
import com.flipkart.dao.FlipFitGymCustomerDAOImpl;
import com.flipkart.exceptions.InvalidChoiceException;

import java.util.Scanner;

public class GymFlipFitOwnerMenu {
    public static void getFlipFitOwnerView() throws InvalidChoiceException {
        try {
            FlipFitGymOwnerBusiness GOBservice = new FlipFitGymOwnerBusiness();
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("Gym Owner Menu:> ");
                System.out.println("Choose an option:" +
                        "\n 1. Add Centre" +
                        "\n 2. View Centres" +
                        "\n 3. View Customers" +
                        "\n 4. View Payments" +
                        "\n 5. Edit Owner Details" +
                        "\6 6. Logout");
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Give details to add Centre : ");
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Enter Owner ID: ");
                        int ownerID = scanner.nextInt();
                        System.out.println("Enter Capacity: ");
                        int capacity = scanner.nextInt();
                        System.out.println("Enter City: ");
                        String city = scanner.next();
                        System.out.println("Enter State: ");
                        String state = scanner.next();
                        System.out.println("Enter Pincode: ");
                        String pincode = scanner.next();

                        FlipFitAdminDAOImpl adminDAO = new FlipFitAdminDAOImpl();
                        FlipFitAdminBusiness flipFitAdminBusiness = new FlipFitAdminBusiness(adminDAO);
                        boolean approved = flipFitAdminBusiness.validateOwner(ownerID);

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
                        break;
                    }
                    case 2: {
                        System.out.println("View Centres");
                        GOBservice.viewCentres();
                        break;
                    }
                    case 3: {
                        System.out.println("View Customers");
//                        GOBservice.viewFlipFitCustomers();
                        break;
                    }
                    case 4: {
                        System.out.println("View Payments");
                        GOBservice.viewPayments();
                        break;
                    }
                    case 5: {
                        System.out.println("Edit Details");
                        boolean change = GOBservice.editDetails();
                        if (change) {
                            System.out.println("Successfully edited details");
                        } else {
                            System.out.println("Failed to edit details");
                        }
                        break;
                    }
                    case 6: {
                        System.out.println("Successful logout");
                    }
                    default: {
                        throw new InvalidChoiceException("Invalid choice entered: " + choice);
                    }
                }
            }
            while (choice != 6);
        } catch (InvalidChoiceException e) {
            System.out.println(e.getMessage());
        }
    }
}
