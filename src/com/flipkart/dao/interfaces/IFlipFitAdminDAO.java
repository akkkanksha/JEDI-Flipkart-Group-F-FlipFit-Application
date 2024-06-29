package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;


/**
 IFlipFitAdminDAO interface defines methods for managing admin operations within the FlipFit Gym application.
 */
public interface IFlipFitAdminDAO {


     /**adminLogin - It is a method to validate the login credentials of an admin user.
     It takes FlipFitAdmin as a parameter and object containing login credentials.
     It returns a boolean as true or false which indicates if the deletion was successful or not.
     if successful - true, if not successful - false
      */
    public boolean adminLogin(FlipFitAdmin adminUser);


      /**getPendingOwnerList - It is a method which Retrieves a list of gym owners who are pending approval.
      It returns a List of FlipFitGymOwner objects representing pending gym owners.*/
    public List<FlipFitGymOwner> getPendingOwnerList();

      /**getUserList - It is a method which Retrieves a list of all users in the system.
      It returns a List of FlipFitGymCustomer objects representing all users.*/
    public List<FlipFitGymCustomer> getUserList();

      /**Validates and approves a gym owner based on the provided owner ID
       It takes ownerId as parameter and The ID of the gym owner to be validated.
       It returns a boolean as true or false which indicates if the deletion was successful or not.
       if successful - true, if not successful - false     */
    public boolean validateOwner(int ownerId);

    /**
     deleteOwner - It is a method which deletes a gym owner from the system based on the provided owner ID.
     It takes ownerId as parameter and The ID of the gym owner to be deleted.
     It returns a boolean as true or false which indicates if the deletion was successful or not.
     if successful - true, if not successful - false
     */
    public boolean deleteOwner(int ownerId);
}
