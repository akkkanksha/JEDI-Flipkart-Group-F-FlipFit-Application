package com.flipkart.business.interfaces;

import com.flipkart.exceptions.InvalidChoiceException;
import com.flipkart.bean.*;

import java.util.List;

public interface IFlipFitGymOwner {
    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre) throws InvalidChoiceException;
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner flipFitGymOwner);
//    public  List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre flipFitGymCentre);
    public List<FlipFitPayments> viewPayments();
    public FlipFitGymOwner editDetails(FlipFitGymOwner flipFitGymOwner) throws InvalidChoiceException;
    public FlipFitGymOwner registerOwner(FlipFitGymOwner owner);
    public FlipFitUser login(FlipFitUser user);

    FlipFitSlots addSlot(FlipFitSlots flipFitSlot);
}
