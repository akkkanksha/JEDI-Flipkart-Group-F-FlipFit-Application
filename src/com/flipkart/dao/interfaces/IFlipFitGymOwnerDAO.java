package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface IFlipFitGymOwnerDAO {
    public boolean addCentre(FlipFitGymCentre centre);
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner owner);
    public void viewFlipFitCustomers();
    public boolean editDetails();
}
