package com.flipkart.client;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.BookingsBusiness;
import com.flipkart.business.FlipFitGymCentreBusiness;
import com.flipkart.business.FlipFitGymCustomerBusiness;
import com.flipkart.dao.FlipFitBookingDAOImpl;
import com.flipkart.dao.FlipFitGymCentreDAOImpl;
import com.flipkart.dao.FlipFitGymCustomerDAOImpl;
import com.flipkart.exceptions.ExceptionHandler;
import com.flipkart.exceptions.InvalidChoiceException;

import java.util.Scanner;

import java.util.List;

public class GymFlipFitCustomerMenu {

    public static void getFlipFitCustomerMenu(FlipFitUser gymCustomer) throws InvalidChoiceException {
        try {
            int userId = gymCustomer.getUserID();
            Scanner sc = new Scanner(System.in);
            FlipFitGymCustomerDAOImpl flipFitGymCustomerDAO = new FlipFitGymCustomerDAOImpl();
            FlipFitGymCustomerBusiness FCBservice = new FlipFitGymCustomerBusiness(flipFitGymCustomerDAO);
            FlipFitGymCentreDAOImpl flipFitGymCenterDAO = new FlipFitGymCentreDAOImpl();
            FlipFitGymCentreBusiness FCService = new FlipFitGymCentreBusiness(flipFitGymCenterDAO);
            FlipFitBookingDAOImpl flipFitBookingDAO = new FlipFitBookingDAOImpl();
            BookingsBusiness BService = new BookingsBusiness(flipFitBookingDAO);
            int choice =0;
            do {
                System.out.println("FlipFit Customer Menu:> ");
                System.out.println("Choose an option:" +
                        "\n 1. View Booked Slots" +
                        "\n 2. View Centres" +
                        "\n 3. Logout");
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("View Booked Slots:");
                        FCBservice.viewBookedSlots(userId);
                        System.out.println("Type 2. If you wish to cancel");
                        choice = sc.nextInt();
                        if (choice == 2) {
                            System.out.println("Choose the booking ID you wish to cancel");
                            int bookingId = sc.nextInt();
                            BService.deleteBooking(bookingId);
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("View Centres");
                        List<FlipFitGymCentre> centreList = FCBservice.viewCentres();
                        for (FlipFitGymCentre centre : centreList) {
                            System.out.println("CentreId is: " + centre.getCentreID() + " City is: " + centre.getCity() + " Pincode is: " + centre.getPincode());
                        }
                        System.out.println("Choose a centre you want to book slot in");
                        int centreId = sc.nextInt();
                        List<FlipFitSlots> slotsList = FCService.viewAvailableSlots(centreId);
                        System.out.println("These are the available slots:");
                        for (FlipFitSlots flipFitSlots : slotsList) {
                            System.out.println("Slot Id is: " + flipFitSlots.getSlotId() + " Slot Timing is: " + flipFitSlots.getSlotTime() + " Availability is: " + flipFitSlots.getSeatsAvailable() + " CentreId is: " + flipFitSlots.getCentreId());
                        }
                        System.out.println("Give the startTime you wish to book");
                        int startTime = sc.nextInt();
                        System.out.println("Give the centre ID: ");
                        int centreID = sc.nextInt();
                        BService.makeBooking(userId, centreID, startTime);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("successful logout");
                    }
                    default: {
                        throw new InvalidChoiceException("Invalid choice entered: " + choice);
                    }
                }
            }
            while (choice != 4) ;
        } catch (InvalidChoiceException e) {
            ExceptionHandler.InvalidChoiceMainMenu(e);
        }
    }
}
