package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

import java.util.List;

public interface IFlipFitGymOwnerDAO {
    public FlipFitGymCentre addCentre(FlipFitGymCentre centre);
    public List<FlipFitGymCentre> viewCentresByOwnerID(FlipFitGymOwner owner);
//    List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre centre);
    public FlipFitGymOwner editDetails(FlipFitGymOwner owner);
    public FlipFitGymOwner addGymOwner(FlipFitGymOwner owner, FlipFitUser user);
    public FlipFitUser addUser(FlipFitUser user);
}