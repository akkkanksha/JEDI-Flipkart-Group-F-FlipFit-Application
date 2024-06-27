package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitSlots;

public interface IFlipFitSlotDAO {
    public FlipFitSlots addSlot(int centerId, long startTime, int seatsAvailable);
    public boolean deleteSlot(int slotID, int seatsAvailable);
}
