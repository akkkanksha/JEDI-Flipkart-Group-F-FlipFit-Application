package com.flipkart.business;
import com.flipkart.bean.*;
import com.flipkart.business.interfaces.IFlipFitGymCustomer;
import java.util.List;
import java.util.Scanner;

import com.flipkart.dao.FlipFitBookingDAOImpl;
import com.flipkart.dao.FlipFitGymCustomerDAOImpl;
import com.flipkart.dao.FlipFitSlotDAOImpl;

public class FlipFitGymCustomerBusiness implements  IFlipFitGymCustomer {

    public void registerCustomer(FlipFitGymCustomer flipFitGymCustomer) {


        System.out.println("Registering Customer " + username);
    }


    @Override
    public void viewBookedSlots(int userId) {

        System.out.println("Viewing booked slots:> ");
        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        FlipFitSlotDAOImpl slotDAO = new FlipFitSlotDAOImpl();
        List<FlipFitBooking> bookingsList= bookingDAO.getAllBookings(userId);
        for (FlipFitBooking booking : bookingsList) {
            System.out.println("Booking ID: " + booking.getBookingId() + "Slot timing " + booking.getSlotTime());
        }

    }
    public boolean checkBookingConflicts(int userId, int slotId) {
        System.out.println("Checking conflict for slot " + slotId);
        FlipFitGymCustomerDAOImpl customerDAO = new FlipFitGymCustomerDAOImpl();
        return customerDAO.checkBookingConflicts(userId, slotId);
    }
    public void viewCentres() {
        System.out.println("view centres called:> ");
        FlipFitGymCustomerDAOImpl customerDAO = new FlipFitGymCustomerDAOImpl();
        List<FlipFitGymCentre> centreList = customerDAO.viewCentres();
        for (FlipFitGymCentre centre : centreList) {
            System.out.println("Centre Id is " + centre.getCentreID() + "OwnerID is " + centre.getOwnerID() + "Capacity is " + centre.getCapacity());
        }
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
        FlipFitGymCustomer fitGymCustomer = new FlipFitGymCustomer();
        switch (choice) {
            case 1: {
                System.out.println("Enter New Name");
                String newName = sc.next();
                fitGymCustomer.setUserName(newName);
                break;
            }
            case 2: {
                System.out.println("Enter New Phone Number");
                String newPhoneNumber = sc.next();
                fitGymCustomer.setUserName(newPhoneNumber);
                break;
            }
            case 3: {
                System.out.println("Enter New Email");
                String newEmail = sc.next();
                fitGymCustomer.setUserName(newEmail);
                break;
            }
            case 4: {
                System.out.println("Enter New City");
                String newCity = sc.next();
                fitGymCustomer.setUserName(newCity);
                break;
            }
            case 5: {
                System.out.println("Enter New pincode");
                String newPincode = sc.next();
                fitGymCustomer.setUserName(newPincode);
                break;
            }
            default: {
                System.out.println("Invalid Choice");
                return false;
            }
        }
        System.out.println("Edit details called:> ");
        return true;
    }
}
