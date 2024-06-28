package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitSlots;

import java.util.ArrayList;
import java.util.List;

public interface IFlipFitSlotDAO {

    // addSlot - It is a Method to add a new slot.
    // It takes FlipFitSlots object as a parameter and adds it to the system slot.
    // Returns a boolean as true or false which indicates if the addition was successful.
    // if successful - true, if not successful - false
    public boolean addSlot(FlipFitSlots slot);

    // deleteSlot - It is a method to delete an already existing slot.
    // It takes an integer slotId as a parameter to identify which slot has to delete.
    // Returns a boolean as true or false which indicates if the addition was successful.
    // if successful - true, if not successful - false
    public boolean deleteSlot(int slotId);

    // changeSlot - It is a method to change an existing slot.
    // It takes FlipFitSlots object containing updated slot information.
    // Returns a boolean as true or false which indicates if the addition was successful.
    // if successful - true, if not successful - false
    public boolean changeSlot(FlipFitSlots slot);

    // getAllSlots - It is a method to retrieve all the slots associated with a specific slotID.
    // It takes an integer slotID as a parameter to identify which type of slot's details to retrieve.
    // Returns a boolean as true or false which indicates if the addition was successful.
    // if successful - true, if not successful - false
    public List<FlipFitSlots> getAllSlots(int slotID);

    // getSlotDetailsById - It is a method to get detailed information about a specific slot by its Id.
    // Takes an integer slotId as a parameter to identify which slot's details to retrieve by the slotId.
    // Returns a boolean as true or false which indicates if the addition was successful.
    // if successful - true, if not successful - false
    public FlipFitSlots getSlotDetailsById(int slotId);

    // getSlotDetails - It is a method to get detailed information about a specific slot by its slotId.
    // Returns a list of FlipFitSlots objects, multiple elements if there are related slots.
    public List<FlipFitSlots> getSlotDetails(int slotId);
}
