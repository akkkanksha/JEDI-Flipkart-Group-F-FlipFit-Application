package com.flipkart.business;

import com.flipkart.bean.FlipFitSlots;
import com.flipkart.business.interfaces.IFlipFitSlots;
import com.flipkart.dao.FlipFitSlotDAOImpl;

public class FlipFitSlotsBusiness implements IFlipFitSlots {

    public boolean updateAvailability(FlipFitSlots flipFitSlots) {
        System.out.println("Updating Slot Availability");
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
        flipFitSlotDAO.changeSlot(flipFitSlots);
        return true;
    }

    public void getSlotDetails() {
        System.out.println("Getting Slot Details");
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();

    }
}
