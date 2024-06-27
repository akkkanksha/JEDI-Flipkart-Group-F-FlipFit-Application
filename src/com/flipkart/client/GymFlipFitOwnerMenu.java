package com.flipkart.client;

import com.flipkart.business.FlipFitGymCentreBusiness;
import com.flipkart.business.FlipFitGymOwnerBusiness;

import java.util.Scanner;

public class GymFlipFitOwnerMenu {
    public static void getFlipFitOwnerView() {
        FlipFitGymOwnerBusiness GOBservice = new FlipFitGymOwnerBusiness();
        System.out.println("Gym Owner Menu:> ");
        System.out.println("Choose an option:" +
                "\n 1. Add Centre" +
                "\n 2. View Centres" +
                "\n 3. View Customers" +
                "\n 4. View Payments" +
                "\n 5. Edit Owner Details");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
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
                System.out.println("Edit Details");
                boolean change = GOBservice.editDetails();
                if (change) {
                    System.out.println("Successfully edited details");
                }
                else {
                    System.out.println("Failed to edit details");
                }
                break;
            }
        }
    }
}
