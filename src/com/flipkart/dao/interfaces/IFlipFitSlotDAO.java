package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitSlots;

public interface IFlipFitSlotDAO {
    public boolean addSlot(FlipFitSlots slot);
    public boolean deleteSlot(int slotId);
    public boolean changeSlot(FlipFitSlots slot);
}
