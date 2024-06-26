package com.flipkart.business;

import com.flipkart.business.interfaces.ISlots;

public class SlotsBusiness implements ISlots {

    public boolean updateAvailability() {
        System.out.println("Updating Slot Availability");
        return true;
    }

    public void getSlotDetails() {
        System.out.println("Getting Slot Details");
    }
}
