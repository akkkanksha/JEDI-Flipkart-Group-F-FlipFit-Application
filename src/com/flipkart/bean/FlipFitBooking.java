package com.flipkart.bean;

public class FlipFitBooking {
    private int bookingID;
    public int userID;
    private int slotID;
    private int slotTime;
    private boolean isdeleted;

    public int getBookingId() {
        return bookingID;
    }


    public void setBookingId(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getUserId() {
        return userID;
    }

    public void setUserId(int userId) {
        this.userID = userID;
    }

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }


    public boolean isdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public int getSlotTime() {
        return slotTime;
    }
    public void setSlotTime(int slotTime) {
        this.slotTime = slotTime;
    }
}