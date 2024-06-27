package com.flipkart.business;

import com.flipkart.business.interfaces.IFlipFitSlots;

public class FlipFitSlotsBusiness implements IFlipFitSlots {

    public boolean updateAvailability() {
        System.out.println("Updating Slot Availability");
        return true;
    }

    public void getSlotDetails() {
        System.out.println("Getting Slot Details");
    }
}
