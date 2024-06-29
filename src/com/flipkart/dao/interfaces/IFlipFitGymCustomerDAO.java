package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitSlots;

import java.util.List;

/**
 IFlipFitGymCustomerDAO interface defines methods for customer-related operations in the FlipFit Gym application.
 This includes viewing and managing booked slots, handling payments, and editing customer details.
 */
public interface IFlipFitGymCustomerDAO {

    /**
     viewBookedSlots - It is  a method which retrieves a list of slots that a customer has booked.
     It takes userID as parameter and  the ID of the user for whom to view booked slots.
     It returns a List of FlipFitSlots objects representing the booked slots.
     */
    public List<FlipFitSlots> viewBookedSlots(int userID);

    /**
     checkBookingConflicts - It is a method which Checks if there are any booking conflicts for a user attempting to book a specific slot.
     It takes userID as parameter and the ID of the user trying to book a slot.
     It takes slotID as second parameter and the ID of the slot the user is attempting to book.
     It returns a boolean as true or false which indicates if the payment was successful or not.
     if successful - true, if not successful - false     */
    public boolean checkBookingConflicts(int userID, int slotID);

    /**
     viewCentres - It is a method which retrieves a list of all available gym centres.
     It returns a List of FlipFitGymCentre objects representing all available gym centres.
     */
    public List<FlipFitGymCentre> viewCentres();

    /**
     makePayment - It is a method which initiates a payment process for a user.
     It takes userID as parameter and the ID of the user making the payment.
     It returns a boolean as true or false which indicates if the payment was successful or not.
     if successful - true, if not successful - false
     */
    public boolean makePayment(int userID);

    /**
     viewPaymentDetails - It is a method which views the payment details for a specific user.
     It takes userID as parameter and the ID of the user for whom to view payment details.
     */
    public void viewPaymentDetails(int userID);

    /**
     editPaymentDetails - It is a method which edits the payment details for a specific user.
     It takes userID as parameter and the ID of the user for whom to edit payment details.
     */
    public void editPaymentDetails(int userID);

    /**
     editDetails - It is a method which edits the details of a customer.
     It takes customer as parameter and FlipFitGymCustomer object containing the updated customer details.
     * It returns true if the details are successfully updated, false otherwise.
     */
    public boolean editDetails(FlipFitGymCustomer customer);
}