package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.interfaces.IFlipFitGymOwner;

import java.util.Scanner;

public class FlipFitGymOwnerBusiness implements IFlipFitGymOwner {
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
        Scanner sc=new Scanner(System.in);
        System.out.println("Select Fields you want to edit ");
        System.out.println("Choose an option:" +
                "\n 1. Name" +
                "\n 2. Phone number" +
                "\n 3. Email" +
                "\n 4. City" +
                "\n 5. pincode");
        int choice=sc.nextInt();
        FlipFitGymOwner FOwner = new FlipFitGymOwner();
        switch (choice) {
            case 1: {
                System.out.println("Enter New Name");
                String newName = sc.next();
                FOwner.setUserName(newName);
                break;
            }
            case 2: {
                System.out.println("Enter New Phone Number");
                String newPhoneNumber = sc.next();
                FOwner.setUserName(newPhoneNumber);
                break;
            }
            case 3: {
                System.out.println("Enter New Email");
                String newEmail = sc.next();
                FOwner.setUserName(newEmail);
                break;
            }
            case 4: {
                System.out.println("Enter New City");
                String newCity = sc.next();
                FOwner.setUserName(newCity);
                break;
            }
            case 5: {
                System.out.println("Enter New pincode");
                String newPincode = sc.next();
                FOwner.setUserName(newPincode);
                break;
            }
            default: {
                System.out.println("Invalid Choice");
                return false;
            }
        }
        return true;
    }
}
