package com.flipkart.business.interfaces;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface IFlipFitAdmin {
    public boolean adminLogin(FlipFitAdmin admin);
    public List<FlipFitGymOwner> getPendingOwnerList();
    public List<FlipFitGymOwner> getApprovedOwnerList();
    public List<FlipFitGymCustomer> getUserList();
    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId);
    public boolean validateOwner(int ownerId);
    public boolean deleteOwner(int ownerId);
}
