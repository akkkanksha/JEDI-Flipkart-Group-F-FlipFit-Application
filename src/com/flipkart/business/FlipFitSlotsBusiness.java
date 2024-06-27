package com.flipkart.business;

import com.flipkart.bean.FlipFitSlots;
import com.flipkart.business.interfaces.IFlipFitSlots;
import com.flipkart.dao.FlipFitSlotDAOImpl;

public class FlipFitSlotsBusiness implements IFlipFitSlots {

    public boolean updateAvailability(int slotId) {
        System.out.println("Updating Slot Availability");
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
        FlipFitSlots flipFitSlots = flipFitSlotDAO.getSlotDetailsById(slotId);
        FlipFitSlots currflipFitSlots = flipFitSlots;
        currflipFitSlots.setSeatsAvailable(flipFitSlots.getSeatsAvailable()-1);
        flipFitSlotDAO.changeSlot(currflipFitSlots);
        return true;
    }

    public void getSlotDetails() {
        System.out.println("Getting Slot Details");
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();

    }
}
