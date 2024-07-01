package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitPayments;
import java.util.List;

/**
 IFlipFitPaymentsDAO interface defines methods for managing payment information within the FlipFit Gym application.
 It includes functionalities to set and delete payment details associated with users.
 */
public interface IFlipFitPaymentsDAO {

    public List<FlipFitPayments> viewPaymentInfo(int userID);
    /**
     setPaymentInfo - It is a method which sets or updates the payment information for a user.
     It takes FFP as parameter and FlipFitPayments object containing the payment details to be set or updated.
     */
    public void setPaymentInfo(FlipFitPayments FFP);

    /**
     deletePaymentInfo - It is a method which deletes the payment information for a user.
     It takes FFP as parameter and  FlipFitPayments object representing the payment details to be deleted.
     */
    public void deletePaymentInfo(FlipFitPayments FFP);
}
