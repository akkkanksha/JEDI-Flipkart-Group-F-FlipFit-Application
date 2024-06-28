package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

import java.util.List;

public interface IFlipFitGymOwnerDAO {
    public boolean addCentre(FlipFitGymCentre centre);
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner owner);
    List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre centre);
    public boolean editDetails(FlipFitGymOwner owner);
}