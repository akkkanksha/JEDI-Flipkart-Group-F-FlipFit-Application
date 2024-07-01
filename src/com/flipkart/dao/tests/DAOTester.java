package com.flipkart.dao.tests;
import com.flipkart.bean.*;
import com.flipkart.dao.*;
import com.flipkart.dao.interfaces.IFlipFitBookingDAO;
import com.flipkart.dao.interfaces.IFlipFitSlotDAO;

import java.util.ArrayList;
import java.util.List;

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
//        DAOT.gymOwnerTester();

        // test bookings
//        DAOT.testBookings();

        // test slots
//        DAOT.testSlots();

        // test GymCustomer
        DAOT.gymCustomerTester();

    }

    public void gymCustomerTester() {
        FlipFitUser FFU = new FlipFitUser();
        FlipFitGymCustomer FFGCU = new FlipFitGymCustomer();
        FlipFitGymCustomerDAOImpl FFGCDAO = new FlipFitGymCustomerDAOImpl();

        FFGCU.setUserId(101);
        FFGCU.setCity("Pune");
        List<FlipFitBooking> ffb = FFGCDAO.viewBookedSlots(FFGCU.getUserId());
        for (FlipFitBooking flipFitBookings : ffb) {
            System.out.println(flipFitBookings.getBookingId());
        }

        List<FlipFitGymCentre> ffgc = FFGCDAO.viewCentres();
        for (FlipFitGymCentre ffgcs : ffgc) {
            System.out.println(ffgcs.getCentreID());
        }

        FFGCU.setUserId(191);
        List<FlipFitPayments> FFP = FFGCDAO.viewPaymentDetails(FFGCU.getUserId());
        for (FlipFitPayments flipFitPayments : FFP) {
            System.out.println(flipFitPayments.getPaymentInfo());
        }

        FFGCU.setUserId(84);
        FFGCU.setPinCode("411027");
        System.out.println(FFGCDAO.editDetails(FFGCU));

        int slotID = 5;
        FFGCU.setUserId(108);
        System.out.println(FFGCDAO.checkBookingConflicts(FFGCU.getUserId(), slotID));

//
//        FFU.setUserName("PP");
//        FFU.setPassword("pp2");
//        FFU.setRoleID(1);
//        FFU.setEmailID("pp@mail");
//        FFU.setPhoneNumber("9800756987");
//        FFU.setUserID(1);
//
//
//        FlipFitUser FFU1 = new FlipFitUser();
//
//        FFU1.setUserName("PP1");
//        FFU1.setPassword("pp21");
//        FFU1.setRoleID(11);
//        FFU1.setEmailID("pp1@mail");
//        FFU1.setPhoneNumber("98007569871");
//        FFU1.setUserID(2);

//        FlipFitUserDAOImpl FFUDAO = new FlipFitUserDAOImpl();
//        FFUDAO.addUser(FFU);
//        FFUDAO.addUser(FFU1);

//
//        FlipFitGymCustomerDAOImpl FFGCDAO = new FlipFitGymCustomerDAOImpl();
//        List<FlipFitSlots> slots=FFGCDAO.viewBookedSlots(FFU.getUserID());
//        for(FlipFitSlots slot : slots){
//            System.out.println(slot.getSlotId());
//        }
    }

    public void testSlots() {
        FlipFitSlotDAOImpl slotDAO = new FlipFitSlotDAOImpl();

        FlipFitSlots newSlot = new FlipFitSlots();
//        newSlot.setSlotId(1);
        newSlot.setCentreId(557);
        newSlot.setSlotTime(System.currentTimeMillis());
        newSlot.setSeatsAvailable(50);

        System.out.println("Adding a new slot:");
        boolean isAdded = slotDAO.addSlot(newSlot);
        System.out.println("Slot added: " + isAdded);

        int centerIdToRetrieve = 288;
        System.out.println("\nRetrieving all slots for center ID: " + centerIdToRetrieve);
        List<FlipFitSlots> slots = slotDAO.getAllSlots(centerIdToRetrieve);
        for (FlipFitSlots slot : slots) {
            System.out.println("Slot ID: " + slot.getSlotId() + ", Center ID: " + slot.getCentreId() +
                    ", Slot Time: " + slot.getSlotTime() + ", Seats Available: " + slot.getSeatsAvailable());
        }

        FlipFitSlots slotToUpdate = new FlipFitSlots();
        slotToUpdate.setSlotId(2);
        slotToUpdate.setCentreId(789);
        slotToUpdate.setSlotTime(System.currentTimeMillis() + 3600000);
        slotToUpdate.setSeatsAvailable(45);

        System.out.println("\nUpdating slot with ID: " + slotToUpdate.getSlotId());
        boolean isUpdated = slotDAO.changeSlot(slotToUpdate);
        System.out.println("Slot updated: " + isUpdated);

        int slotIdToDelete = 878;
        System.out.println("\nDeleting slot with ID: " + slotIdToDelete);
        boolean isDeleted = slotDAO.deleteSlot(slotIdToDelete);
        System.out.println("Slot deleted: " + isDeleted);

        int slotIdToGet = 887;
        System.out.println("\nGet slot details for slot ID: " + slotIdToGet);
        FlipFitSlots slot = slotDAO.getSlotDetails(slotIdToGet);
        System.out.println("Slot ID: " + slot.getSlotId() + ", Center ID: " + slot.getCentreId() +
                    ", Slot Time: " + slot.getSlotTime() + ", Seats Available: " + slot.getSeatsAvailable());

    }

    public void testBookings() {
        IFlipFitBookingDAO bookingDAO = new FlipFitBookingDAOImpl();

        FlipFitBooking newBooking = new FlipFitBooking();
        newBooking.setUserId(101);
        newBooking.setSlotId(5);
        newBooking.setIsdeleted(false);
        newBooking.setSlotTime(3);

        //Connection con = GetConnection.getConnection();

        System.out.println("Making a new booking:");
        bookingDAO.makeBooking(newBooking);


        int userIdToGet = 101;

        System.out.println("\nGet all bookings for user ID: " + userIdToGet);
        List<FlipFitBooking> bookings = bookingDAO.getAllBookings(userIdToGet);
        for (FlipFitBooking booking : bookings) {
            System.out.println("Booking ID: " + booking.getUserId() + ", Slot ID: " + booking.getSlotId() + ", Is Deleted: " + booking.isDeleted());
        }

        int bookingIdToDelete = 833;
        System.out.println("\nDeleting booking with ID: " + bookingIdToDelete);
        boolean deleteSuccess = bookingDAO.deleteBooking(bookingIdToDelete);
        System.out.println("Booking deletion successful: " + deleteSuccess);

        bookingDAO = new FlipFitBookingDAOImpl();

        int bookingIdToGet = 708;
        System.out.println("Get booking details for booking ID: " + bookingIdToGet);
        List<FlipFitBooking> bookingDetails = bookingDAO.getBookingDetails(bookingIdToGet);
        for (FlipFitBooking booking : bookingDetails) {
            System.out.println("Booking ID: " + booking.getUserId() + ", Slot ID: " + booking.getSlotId() + ", Is Deleted: " + booking.isDeleted());
        }

        FlipFitBooking ffb = bookingDAO.getBookingDetailsByBookingId(708);
        System.out.println(ffb.getBookingId());
    }

    public void gymOwnerTester() {
        FlipFitGymOwner FFGO = new FlipFitGymOwner();
        FlipFitGymOwnerDAOImpl FFGODAO = new FlipFitGymOwnerDAOImpl();

        FFGO.setAadharNumber("123456789021");
        FFGO.setGSTIN("GST139486");
        FFGO.setPAN("PAN2F1241");
        FFGO.setIsApproved(true);


        FFGO.setUserId(344);
//        List<FlipFitGymCentre> FFGOUser = FFGODAO.viewCentres(FFGO);
//        for (FlipFitGymCentre fs : FFGOUser){
//            System.out.println(fs.getCentreID());
//        }

        FlipFitGymCentre FFGC = new FlipFitGymCentre();
        FFGC.setOwnerID(344);
        FFGC.setApproved(true);
        FFGC.setCapacity(45);
        FFGC.setCity("Ranchi");
        FFGC.setState("JH");
        FFGC.setPincode("834004");

        List<FlipFitUser> FFV = FFGODAO.viewFlipFitCustomers(FFGC);
        for (FlipFitUser fs : FFV){
            System.out.println(fs.getUserID());
        }
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
        FFDAO.deleteGymCentre(FFGC);

        System.out.println("Testing viewCentresByCity");
        ArrayList<FlipFitGymCentre> arr = FFDAO.viewCentres("Pune");
        for(FlipFitGymCentre ffgc : arr){
            System.out.println(ffgc.getCentreID());
        }

        System.out.println("Testing viewAvailableSlots");
        FFGC.setCentreID(187);
        ArrayList<FlipFitSlots> ffsarr = FFDAO.viewAvailableSlots(FFGC);
        for(FlipFitSlots fs : ffsarr){
            System.out.println(fs.getSlotId());
        }
    }
}
