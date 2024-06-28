package com.flipkart.bean;

public class FlipFitBooking {
    private int bookingId;
    public int userId;
    private int slotId;
    private int slotTime;
    private boolean isdeleted;

    public int getBookingId() {
        return bookingId;
    }


    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
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