package com.flipkart.client;

import com.flipkart.business.FlipFitGymCentreBusiness;
import com.flipkart.business.FlipFitGymOwnerBusiness;

import java.util.ArrayList;
import java.util.Scanner;

public class GymFlipFitOwnerMenu {
    public static void getFlipFitOwnerView() {

        FlipFitGymOwnerBusiness GOBservice = new FlipFitGymOwnerBusiness();
        FlipFitGymCentreBusiness GCService = new FlipFitGymCentreBusiness();
        System.out.println("Gym Owner Menu:> ");
        System.out.println("Choose an option:" +
                "\n 1. Add Centre" +
                "\n 2. View Centres" +
                "\n 3. View Customers" +
                "\n 4. View Payments" +
                "\n 5. Edit Owner Details");
        Scanner in = new Scanner(System.in);

        int choice = 0;
        switch (choice) {
            case 1: {
                System.out.println("Add Centre");
                System.out.println("Enter Centre City:");
                String centreCity = in.nextLine();
                System.out.println("Enter Centre State:");
                String centreState = in.nextLine();
                System.out.println("Enter Centre Zip Code:");
                String centreZipCode = in.nextLine();
                System.out.println("Enter Centre capacity:");
                String centreCapacity = in.nextLine();
                System.out.println("Enter Centre slot timings with comma separated values like (6,11,23):");
                String slotsTiming = in.nextLine();
                GCService.createGymCentre(centreCity, centreState, centreZipCode, centreCapacity, slotsTiming);
                break;
            }
            case 2: {
                String ownerId = "101";
                System.out.println("View Centres for this owner");
                GCService.viewAllGymCentresByOwnerId(ownerId);
                break;
            }
            case 3: {
                System.out.println("View Customers");
                GOBservice.viewFlipFitCustomers("101");
                break;
            }
            case 4: {
                System.out.println("View Payments");
                GOBservice.viewPayments();
                break;
            }
            case 5: {
                String ownerId = "101";
                System.out.println("Edit Owner Details");
                System.out.println("Gym Owner details edited:> " + GOBservice.editDetails(ownerId));
                break;
            }
        }
    }

    public static void getFlipFitCentreMenu() {
        // Gym Centre
        FlipFitGymCentreBusiness GCBservice = new FlipFitGymCentreBusiness();
        System.out.println("Gym Centre Menu:> ");

//        GCBservice.createGymCentre();
        // System.out.println("Update Gym Centre" + GCBservice.updateGymCentre());
        // System.out.println("Delete Gym Centre" + GCBservice.deleteGymCentre());
//        GCBservice.viewAvailableSlots(101);
    }
}
