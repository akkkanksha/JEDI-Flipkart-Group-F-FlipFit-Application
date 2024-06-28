package com.flipkart.dao.tests;
import com.flipkart.bean.*;
import com.flipkart.dao.*;

import java.util.ArrayList;

public class DAOTester {
    public static void main(String[] args) {
    DAOTester DAOT  = new DAOTester();

        //test payments
//        DAOT.paymentsTester();

        //test user
        DAOT.userTester();

        //test gymcentre
//        DAOT.gymCentreTester();
    }

    public void paymentsTester(){
        FlipFitGymCentre FFGC = new FlipFitGymCentre();
        FlipFitGymCentreDAOImpl FFGCDAO = new FlipFitGymCentreDAOImpl();

        //test part
        FFGC.setOwnerID(344);
        FFGC.setApproved(true);
        FFGC.setCapacity(45);
        FFGC.setCity("Pune");
        FFGC.setState("MH");
        FFGC.setPincode("411027");



        System.out.println("Testing createGymCentre");
        FFGCDAO.createGymCentre(FFGC);
        FFGC.setPincode("560066");

        System.out.println("Testing updateGymCentre");
        FFGCDAO.updateGymCentre(FFGC);
        FFGC.setCentreID(61);

        System.out.println("Testing deleteGymCentre");
        FFGCDAO.deleteGymCentre(FFGC);


        System.out.println("Testing viewCentresByyCity");
        ArrayList<FlipFitGymCentre> arr = FFGCDAO.viewCentresByCity("Pune");
        for(FlipFitGymCentre ffgc : arr){
            System.out.println(ffgc.getCentreID());
        }


        System.out.println("Testing viewAvailableSlots");
        FFGC.setCentreID(187);
        ArrayList<FlipFitSlots> ffsarr = FFGCDAO.viewAvailableSlots(FFGC);
        for(FlipFitSlots fs : ffsarr){
            System.out.println(fs.getSlotId());
        }
    }

    public void userTester(){
        FlipFitUser FFU = new FlipFitUser();
        FlipFitUserDAOImpl FFUDAO = new FlipFitUserDAOImpl();

        FFU.setUserName("PP");
        FFU.setPassword("pp2");
        FFU.setRoleID(1);
        FFU.setEmailID("pp@mail");
        FFU.setPhoneNumber("9800756987");

        System.out.println("Testing addUser");
        FFUDAO.addUser(FFU);

        FlipFitUser FFU1 = new FlipFitUser();
        FFU.setUserName("GG");
        FFU.setPassword("gg2");
        FFU.setRoleID(0);
        FFU.setEmailID("gg@mail");
        FFU.setPhoneNumber("9899756987");

        System.out.println("Testing updateUser");
        FFUDAO.updateUser(FFU);

        System.out.println("Testing getUser");
        FlipFitUser FFU2 = FFUDAO.getUser(644);
        System.out.println(FFU2.getEmailID());
        System.out.println(FFU2.getPhoneNumber());

        System.out.println("Testing login");
        int userID = FFUDAO.login("pp@mail", "pp2");
        if(userID != -1){
            System.out.println("User logged in w/ userID: " + userID);
        }
        else System.out.println("User not registered");
    }

    public void gymCentreTester(){

    }
}
