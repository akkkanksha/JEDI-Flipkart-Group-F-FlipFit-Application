package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitSlots;

import java.util.ArrayList;
import java.util.List;

public interface IFlipFitSlotDAO {
    public boolean addSlot(FlipFitSlots slot);
    public boolean deleteSlot(int slotId);
    public boolean changeSlot(FlipFitSlots slot);
    public List<FlipFitSlots> getAllSlots(int slotID);
    public List<FlipFitSlots> viewBookedSlots(int userID);
    public FlipFitSlots getSlotDetailsById(int slotId);
    public List<FlipFitSlots> getSlotDetails(int slotId);
    public ArrayList<FlipFitSlots> viewAvailableSlots(FlipFitGymCentre FFGC);

}
