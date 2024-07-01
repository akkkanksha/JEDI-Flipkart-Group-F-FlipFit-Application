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
//        DAOT.userTester();

        //test gymcentre
//        DAOT.gymCentreTester();

        //test gymowner
        DAOT.gymOwnerTester();
    }

    public void gymOwnerTester() {
        FlipFitGymOwner FFGO = new FlipFitGymOwner();
        FlipFitGymOwnerDAOImpl FFGODAO = new FlipFitGymOwnerDAOImpl();

        FFGO.setAadharNumber("123456789021");
        FFGO.setGSTIN("GST139486");
        FFGO.setPAN("PAN2F1241");
        FFGO.setIsApproved(true);

        FFGODAO.viewCentres(FFGO);
    }

    public void paymentsTester(){
        FlipFitPayments FFP = new FlipFitPayments();
        FlipFitPaymentsDAOImpl FFPDAO = new FlipFitPaymentsDAOImpl();

        FFP.setUserID(108);
        FFP.setPaymentType(1);
        FFP.setPaymentInfo("ppan@icici");

        FFPDAO.setPaymentInfo(FFP);

        FFP.setPaymentType(2);
        FFP.setPaymentInfo("123456781298;445");
        FFPDAO.setPaymentInfo(FFP);

        FFPDAO.deletePaymentInfo(FFP);
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
        FlipFitGymCentre FFGC = new FlipFitGymCentre();
        FlipFitGymCentreDAOImpl FFDAO = new FlipFitGymCentreDAOImpl();

        FFGC.setOwnerID(644);
        FFGC.setApproved(true);
        FFGC.setCapacity(45);
        FFGC.setCity("Ranchi");
        FFGC.setState("JH");
        FFGC.setPincode("834004");

        System.out.println("Testing createGymCentre");
        FFDAO.createGymCentre(FFGC);

        System.out.println("Testing updateGymCentre");
        FFGC.setCity("Jamshedpur");
        FFDAO.updateGymCentre(FFGC);

        System.out.println("Testing deleteGymCentre");
        FFDAO.deleteGymCentre(FFGC.getCentreID());

        System.out.println("Testing viewCentresByCity");
        ArrayList<FlipFitGymCentre> arr = FFDAO.viewCentresByCity("Pune");
        for(FlipFitGymCentre ffgc : arr){
            System.out.println(ffgc.getCentreID());
        }

        System.out.println("Testing viewAvailableSlots");
        FFGC.setCentreID(187);
        ArrayList<FlipFitSlots> ffsarr = FFDAO.viewAvailableSlots(FFGC.getCentreID());
        for(FlipFitSlots fs : ffsarr){
            System.out.println(fs.getSlotId());
        }
    }
}
