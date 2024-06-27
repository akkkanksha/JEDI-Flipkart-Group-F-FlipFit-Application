package com.flipkart.bean;

public class FlipFitSlots {
    private int slotId;
    private int centreId;
    private long slotTime;
    private int seatsAvailable;

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getCentreId() {
        return centreId;
    }

    public void setCentreId(int centerId) {
        this.centreId = centerId;
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

