package com.flipkart.business;

import com.flipkart.business.interfaces.IGymOwner;

import java.util.Scanner;

public class GymOwnerBusiness implements IGymOwner {
    Scanner scanner = new Scanner(System.in);
    public boolean addCentre() {
        System.out.println("Give the following details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.println("Centre added:> with name " + name + " and city " + city + " and address " + address);
        return true;
    }

    public void viewCentres() {
        System.out.println("Centres listed:> ");
    }
    public void viewFlipFitCustomers() {
        System.out.println("Flip fit customers:> ");
    }
    public void viewPayments() {
        System.out.println("Payments listed:> ");
    }
    public boolean editDetails() {
        System.out.println("Give the following details for update:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.println("Centre updated: with name " + name + " and city " + city + " and address " + address);
        return true;
    }
}
