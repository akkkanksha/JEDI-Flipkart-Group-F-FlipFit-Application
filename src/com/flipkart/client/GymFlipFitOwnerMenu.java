package com.flipkart.client;

import com.flipkart.business.GymCentreBusiness;
import com.flipkart.business.GymOwnerBusiness;

import java.util.Scanner;

public class GymFlipFitOwnerMenu {
    public static void getFlipFitOwnerView() {
        GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();
        System.out.println("Choose an option");
        System.out.println("1. Add Gym Centre");
        System.out.println("2. Update Owner Details");
        System.out.println("3. View All Centres");
        System.out.println("4. View Customer with slots");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        switch (option) {
            case 1: {
                gymOwnerBusiness.addCentre();
                break;
            }
            case 2: {
                gymOwnerBusiness.editDetails();
                break;
            }
            case 3: {
                gymOwnerBusiness.viewCentres();
                break;
            }
            case 4: {
                gymOwnerBusiness.viewFlipFitCustomers();
                break;
            }
        }
    }
}
