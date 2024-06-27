package com.flipkart.business;
import com.flipkart.bean.*;
import com.flipkart.business.interfaces.IFlipFitGymCustomer;

import java.util.Scanner;

public class FlipFitGymCustomerBusiness implements  IFlipFitGymCustomer {

    public void registerCustomer(String username) {
        System.out.println("Registering Customer " + username);
    }


	public void viewBookedSlots(int userId) {
        System.out.println("Viewing booked slots:> ");
    }
    public boolean checkBookingConflicts(int userId, String slot) {
        System.out.println("Checking conflict for slot " + slot);
        return true;
    }
    public void viewCentres() {
        System.out.println("view centres called:> ");

    }
    public boolean makePayment(int userId) {
        System.out.println("Make payment called:> ");
        return true;
    }
    public boolean editDetails(int userId) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Select Fields you want to edit ");
        System.out.println("Choose an option:" +
                "\n 1. Name" +
                "\n 2. Phone number" +
                "\n 3. Email" +
                "\n 4. City" +
                "\n 5. pincode");
        int choice=sc.nextInt();
        FlipFitGymCustomer FCustomer = new FlipFitGymCustomer();
        switch (choice) {
            case 1: {
                System.out.println("Enter New Name");
                String newName = sc.next();
                FCustomer.setUserName(newName);
                break;
            }
            case 2: {
                System.out.println("Enter New Phone Number");
                String newPhoneNumber = sc.next();
                FCustomer.setUserName(newPhoneNumber);
                break;
            }
            case 3: {
                System.out.println("Enter New Email");
                String newEmail = sc.next();
                FCustomer.setUserName(newEmail);
                break;
            }
            case 4: {
                System.out.println("Enter New City");
                String newCity = sc.next();
                FCustomer.setUserName(newCity);
                break;
            }
            case 5: {
                System.out.println("Enter New pincode");
                String newPincode = sc.next();
                FCustomer.setUserName(newPincode);
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
