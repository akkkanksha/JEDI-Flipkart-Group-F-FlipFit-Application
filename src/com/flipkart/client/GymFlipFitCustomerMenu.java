package com.flipkart.client;

import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.business.BookingsBusiness;
import com.flipkart.business.FlipFitGymCentreBusiness;
import com.flipkart.business.FlipFitGymCustomerBusiness;

import java.util.Scanner;

import java.util.List;
public class GymFlipFitCustomerMenu {

    public static void getFlipFitCustomerMenu(FlipFitGymCustomer gymCustomer) {
        int userId = gymCustomer.getUserId();
        Scanner sc=new Scanner(System.in);
        FlipFitGymCustomerBusiness FCBservice = new FlipFitGymCustomerBusiness();
        FlipFitGymCentreBusiness FCService = new FlipFitGymCentreBusiness();
        BookingsBusiness BService = new BookingsBusiness();
        System.out.println("FlipFit Customer Menu:> ");
        System.out.println("Choose an option:" +
                "\n 1. View Booked Slots" +
                "\n 2. View Centres" +
                "\n 3. Edit Details");

        int choice=sc.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("View Booked Slots:");
                FCBservice.viewBookedSlots(gymCustomer.getUserId());
                System.out.println("Type 2. If you wish to cancel");
                choice=sc.nextInt();
                if(choice == 2) {
                    System.out.println("Choose the bookingId you wish to cancel");
                    int bookingId=sc.nextInt();
                    BService.deleteBooking(bookingId);
                }
                break;
            }
            case 2: {
                System.out.println("View Centres");
                FCBservice.viewCentres();
                System.out.println("Choose a centre you want to book a slot in");
                int centreId=sc.nextInt();
                List<FlipFitSlots> slotsList = FCService.viewAvailableSlots(centreId);
                System.out.println("These are the available slots:");
                for (FlipFitSlots flipFitSlots : slotsList) {
                    System.out.println("Slot Id is" + flipFitSlots.getSlotId() + "Slot Timing is " + flipFitSlots.getSlotTime() + "Availability is " + flipFitSlots.getSeatsAvailable());
                }
                System.out.println("Give the SlotId you wish to book");
                int slotId=sc.nextInt();
                BService.makeBooking(slotId, userId);
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
