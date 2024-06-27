package com.flipkart.business;

import com.flipkart.business.interfaces.IFlipFitGymOwner;

import java.util.Scanner;

public class FlipFitGymOwnerBusiness implements IFlipFitGymOwner {
    Scanner in = new Scanner(System.in);

    public boolean addCentre() {
        System.out.println("Give the following details to add the centre:");
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

         return true;
    }

    public void viewCentres() {
        System.out.println("Centres listed:> ");
    }
    public void viewFlipFitCustomers(String OwnerId) {
        System.out.println("Flip fit customers:> ");
    }
    public void viewPayments() {
        System.out.println("Payments listed:> ");
    }
    public boolean editDetails(String OwnerId) {
        System.out.println("Give the following details for update:");
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("City: ");
        String city = in.nextLine();
        System.out.print("Address: ");
        String address = in.nextLine();
        System.out.println("Centre updated: with name " + name + " and city " + city + " and address " + address);
        return true;
    }
}
