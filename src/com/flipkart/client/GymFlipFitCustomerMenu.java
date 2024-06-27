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
                System.out.println("Owner details edited:> " + FCBservice.editDetails(1));
                break;
            }
        }
    }
}
