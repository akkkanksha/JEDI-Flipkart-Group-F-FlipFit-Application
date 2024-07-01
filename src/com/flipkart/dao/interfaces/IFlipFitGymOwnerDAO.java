package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

import java.util.List;


/**
 IFlipFitGymOwnerDAO interface defines methods for gym owner related operations in the FlipFit Gym application.
 It includes functionalities for managing gym centres and viewing customers associated with those centres.
 */
public interface IFlipFitGymOwnerDAO {


    /**
     viewCentres -- It is a method which retrieves and shows a list of gym centres owned by a specific gym owner.
     It takes owner as parameter and FlipFitGymOwner object representing the gym owner.
     It returns a List of FlipFitGymCentre objects representing the gym centres owned by the specified owner.
     */
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner owner);

    /**
     viewFlipFitCustomers - It is a method which retrieves a list of customers associated with a specific gym centre.
     It takes centre as parameter and FlipFitGymCentre object representing the gym centre.
     It returns a List of FlipFitUser objects representing the customers who have booked or are associated with the specified gym centre.
     */
    List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre centre);

    /**
     editDetails - It is a method which edits the details of a gym owner.
     It takes owner as parameter FlipFitGymOwner object containing the updated details of the gym owner.
     * It returns true if the details are successfully updated, false otherwise.
     */
    public boolean editDetails(FlipFitGymOwner owner);
}