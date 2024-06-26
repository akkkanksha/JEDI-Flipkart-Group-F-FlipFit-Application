package com.flipkart.client;

import com.flipkart.business.BookingsBusiness;
import com.flipkart.business.FlipFitCustomerBusiness;
import com.flipkart.business.GymCentreBusiness;
import com.flipkart.business.SlotsBusiness;
import com.flipkart.business.interfaces.ISlots;

import java.util.Scanner;

public class GymFlipFitCustomerMenu {
    public static String slot = "6am-7am";
    static FlipFitCustomerBusiness service = new FlipFitCustomerBusiness();
    static SlotsBusiness slots = new SlotsBusiness();
    static int userId = 101;

    public static void getFlipFitCustomerMenu() {
        System.out.println("Enter your choice : ");
        System.out.println("1. View Booked Slots");
        System.out.println("2. View User Profile");
        System.out.println("3. View Centres");
        Scanner sc=new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                service.viewBookedSlots(userId);
            case 2:
                service.editDetails(userId);
            case 3:{
                service.viewCentres();
                System.out.println("Enter centreId : ");
                int centreId = sc.nextInt();
                slots.getSlotDetails();
                System.out.println("Enter slot number : ");
                int slotNumber = sc.nextInt();
                slots.updateAvailability();

                System.out.println("Successfully booked a slot with centreId : " + centreId + " and slot number : " + slotNumber);
            }
        }

//        service.checkBookingConflicts(userId, slot);
//        service.makePayment(userId);

    }
    public static void getFlipFitBookingMenu() {
        BookingsBusiness BBservice = new BookingsBusiness();
        String userID = "101";
        BBservice.makeBooking(userID);
        BBservice.deleteBooking(userID, slot);
    }
    public static void getFlipFitSlotMenu() {
        // Slots
        ISlots SBservice = new SlotsBusiness();
        SBservice.getSlotDetails();
        System.out.println("Update availability:> " + SBservice.updateAvailability());
    }

}
