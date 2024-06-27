package com.flipkart.client;

import com.flipkart.business.FlipFitGymCustomerBusiness;

import java.util.Scanner;


public class GymFlipFitCustomerMenu {

    public static void getFlipFitCustomerMenu() {

        Scanner sc=new Scanner(System.in);
        FlipFitGymCustomerBusiness FCBservice = new FlipFitGymCustomerBusiness();
        System.out.println("FlipFit Customer Menu:> ");
        System.out.println("Choose an option:" +
                "\n 1. View Booked Slots" +
                "\n 2. View Centres" +
                "\n 3. Edit Details");

        int choice=sc.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("View Booked Slots:");
                FCBservice.viewBookedSlots(1);
                break;
            }
            case 2: {
                System.out.println("View Centres");
                FCBservice.viewCentres();
                break;
            }
            case 3: {
                System.out.println("Edit Details");
                boolean change = FCBservice.editDetails(1);
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
