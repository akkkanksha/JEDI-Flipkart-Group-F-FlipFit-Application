package com.flipkart.bean;

public class FlipFitPayments {
    private int userID;
    // 1 -> UPI / 2 -> Debit Card
    private int paymentType;

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    private String paymentInfo;
}
