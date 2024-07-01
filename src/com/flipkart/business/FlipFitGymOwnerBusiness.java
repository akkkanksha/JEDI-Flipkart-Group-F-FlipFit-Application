package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.interfaces.IFlipFitGymOwner;
import com.flipkart.dao.FlipFitGymCentreDAOImpl;
import com.flipkart.dao.FlipFitGymCustomerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;
import com.flipkart.exceptions.ExceptionHandler;
import com.flipkart.exceptions.InvalidChoiceException;

import java.util.Scanner;
import java.util.List;
public class FlipFitGymOwnerBusiness implements IFlipFitGymOwner {
    Scanner scanner = new Scanner(System.in);
    public boolean addCentre() {
        FlipFitGymCentreBusiness flipFitGymCentre = new FlipFitGymCentreBusiness();
        flipFitGymCentre.createGymCentre();
        return true;
    }

    public void viewCentresByOwnerID(int ownerID) {
        System.out.println("Centres listed:> ");
        FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();
        FlipFitGymOwner owner = flipFitGymOwnerDAO.getOwnerDetailsByID(ownerID);
        FlipFitGymCentreDAOImpl flipFitGymCentreDAO = new FlipFitGymCentreDAOImpl();
        List<FlipFitGymCentre> centreList = flipFitGymCentreDAO.viewCentres(owner);
        for (FlipFitGymCentre centre : centreList) {
            System.out.println("Centre ID: " + centre.getCentreID() + "City is: " + centre.getCity());
        }
    }
    public void viewFlipFitCustomersByOwnerID(int ownerID) {
        System.out.println("Flip fit customers:> ");
        FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();
        FlipFitGymOwner owner = flipFitGymOwnerDAO.getOwnerDetailsByID(ownerID);

        FlipFitGymCustomerDAOImpl flipFitGymCustomerDAO = new FlipFitGymCustomerDAOImpl();
        List<FlipFitGymCustomer> customerList=flipFitGymCustomerDAO.viewFlipFitCustomersByOwner(owner);
        for (FlipFitGymCustomer customer : customerList) {
            System.out.println("Customer ID: " + customer.getUserID() + "EmailID: " + customer.getEmailID() + "PhoneNumber: " + customer.getPhoneNumber()  + "City: " + customer.getCity());
        }

    }
    public void viewPayments() {
        System.out.println("Payments listed:> ");
    }
    public boolean editDetails() throws InvalidChoiceException {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Select Fields you want to edit ");
            System.out.println("Choose an option:" +
                    "\n 1. Name" +
                    "\n 2. Phone number" +
                    "\n 3. Email" +
                    "\n 4. City" +
                    "\n 5. pincode");
            int choice=sc.nextInt();
            FlipFitGymOwner FOwner = new FlipFitGymOwner();
            switch (choice) {
                case 1: {
                    System.out.println("Enter New Name");
                    String newName = sc.next();
                    FOwner.setUserName(newName);
                    break;
                }
                case 2: {
                    System.out.println("Enter New Phone Number");
                    String newPhoneNumber = sc.next();
                    FOwner.setUserName(newPhoneNumber);
                    break;
                }
                case 3: {
                    System.out.println("Enter New Email");
                    String newEmail = sc.next();
                    FOwner.setUserName(newEmail);
                    break;
                }
                case 4: {
                    System.out.println("Enter New City");
                    String newCity = sc.next();
                    FOwner.setUserName(newCity);
                    break;
                }
                case 5: {
                    System.out.println("Enter New pincode");
                    String newPincode = sc.next();
                    FOwner.setUserName(newPincode);
                    break;
                }
                default: {
                    throw new InvalidChoiceException("Invalid choice entered: " + choice);
                }
            }
            return true;
        }
        catch (InvalidChoiceException e)
        {
            ExceptionHandler.InvalidChoiceEditDetailsMenu(e);
            return false;
        }
    }
}
