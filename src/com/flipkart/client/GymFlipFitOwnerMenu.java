package com.flipkart.client;

import com.flipkart.business.GymCentreBusiness;
import com.flipkart.business.GymOwnerBusiness;

import java.util.Scanner;

public class GymFlipFitOwnerMenu {
    public static void getFlipFitOwnerView() {
        GymOwnerBusiness GOBservice = new GymOwnerBusiness();
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
                GOBservice.addCentre();
                break;
            }
            case 2: {
                System.out.println("View Centres");
                GOBservice.viewCentres();
                break;
            }
            case 3: {
                System.out.println("View Customers");
                GOBservice.viewFlipFitCustomers();
                break;
            }
            case 4: {
                System.out.println("View Payments");
                GOBservice.viewPayments();
                break;
            }
            case 5: {
                System.out.println("Edit Owner Details");
                System.out.println("Gym Owner details edited:> " + GOBservice.editDetails());
                break;
            }
        }
    }

    public static void getFlipFitCentreMenu() {
        // Gym Centre
        GymCentreBusiness GCBservice = new GymCentreBusiness();
        System.out.println("Gym Centre Menu:> ");

        GCBservice.createGymCentre();
        // System.out.println("Update Gym Centre" + GCBservice.updateGymCentre());
        // System.out.println("Delete Gym Centre" + GCBservice.deleteGymCentre());
        GCBservice.viewAvailableSlots();
    }
}
