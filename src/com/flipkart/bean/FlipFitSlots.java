package com.flipkart.bean;

public class FlipFitSlots {
    private int slotID;
    private int centreID;
    private long slotTime;
    private int seatsAvailable;

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public int getCentreID() {
        return centreID;
    }

    public void setCentreID(int centerId) {
        this.centreID = centerId;
    }

    public long getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(long startTime) {
        this.slotTime = slotTime;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}

