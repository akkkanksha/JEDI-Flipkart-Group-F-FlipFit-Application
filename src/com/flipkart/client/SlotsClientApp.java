package com.flipkart.client;

import com.flipkart.business.SlotsBusiness;

public class SlotsClientApp {

    public static void main(String[] args) {

        SlotsBusiness SlotBookingService = new SlotsBusiness();
        System.out.println("Update Slots" + SlotBookingService.updateAvailability());
        SlotBookingService.getSlotDetails();

    }

}
