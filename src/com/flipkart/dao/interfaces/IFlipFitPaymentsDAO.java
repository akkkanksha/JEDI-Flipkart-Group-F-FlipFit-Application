package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitPayments;

public interface IFlipFitPaymentsDAO {
    public boolean makePayment(int userID);
    public void viewPaymentDetails(int userID);
    public void editPaymentDetails(int userID);
    public void setPaymentInfo(FlipFitPayments FFP);
    public void deletePaymentInfo(FlipFitPayments FFP);
}
