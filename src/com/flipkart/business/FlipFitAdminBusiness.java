package com.flipkart.business;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.interfaces.IFlipFitAdmin;
import com.flipkart.dao.FlipFitAdminDAOImpl;
import com.flipkart.dao.FlipFitGymCustomerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipFitAdminBusiness implements IFlipFitAdmin {
    private FlipFitAdmin FFAdmin;
    Scanner sc=new Scanner(System.in);
    public FlipFitAdminBusiness(FlipFitAdmin FFAdmin){
        this.FFAdmin=FFAdmin;
    }

    public boolean adminLogin(FlipFitAdmin adminUser){
        FlipFitAdminDAOImpl flipFitAdminDAOImpl=new FlipFitAdminDAOImpl();
        System.out.println("AdminUserBusiness.adminLogin");
        flipFitAdminDAOImpl.adminLogin(adminUser);
        return true;
    }
    public void getPendingOwnerList(){
        System.out.println("AdminUserBusiness.getPendingOwnerList");
        FlipFitGymOwnerDAOImpl flipFitGymOwnerDAOImpl=new FlipFitGymOwnerDAOImpl();
        List<FlipFitGymOwner> flipFitGymOwnerList = flipFitGymOwnerDAOImpl.getOwnerList();
        for(FlipFitGymOwner flipFitGymOwner: flipFitGymOwnerList){
            if(flipFitGymOwner.isApproved==false){
                System.out.println("Owner name :" + flipFitGymOwner.getUserName() + " City :" + flipFitGymOwner.getCity());
            }
        }
        System.out.println("Type the ownerId of owner you wish to approve");
        int ownerID = sc.nextInt();
        if(validateOwner(ownerID)){
            FlipFitGymOwner flipFitGymOwner = flipFitGymOwnerDAOImpl.getOwnerDetailsByID(ownerID);
            flipFitGymOwnerDAOImpl.createOwner(flipFitGymOwner);
        }
    }
    public void getApprovedOwnerList(){
        System.out.println("AdminUserBusiness.getPendingOwnerList");
        FlipFitGymOwnerDAOImpl flipFitGymOwnerDAOImpl=new FlipFitGymOwnerDAOImpl();

        List<FlipFitGymOwner> flipFitGymOwnerList = flipFitGymOwnerDAOImpl.getOwnerList();
        for(FlipFitGymOwner flipFitGymOwner: flipFitGymOwnerList){
            if(flipFitGymOwner.getIsApproved()){
                System.out.println("Owner name :" + flipFitGymOwner.getUserName() + " City :" + flipFitGymOwner.getCity());
            }
        }

        System.out.println("Type the ownerId of owner you wish to delete");
        int ownerID = sc.nextInt();
        if(flipFitGymOwnerDAOImpl.getOwnerDetailsByID(ownerID)!=null){
            deleteOwner(ownerID);
            System.out.println("Successfully deleted owner :" + ownerID);
        }
        else{
            System.out.println("Was not able to delete owner :" + ownerID);
        }
    }
    public List<FlipFitGymCustomer> getUserList(){
        System.out.println("AdminUserBusiness.getUserList");
        FlipFitGymCustomerDAOImpl flipFitGymCustomerDAO=new FlipFitGymCustomerDAOImpl();
        return flipFitGymCustomerDAO.getUserList();
    }
    public boolean validateOwner(int ownerId){
        System.out.println("AdminUserBusiness.validateOwner "+ownerId);
        FlipFitAdminDAOImpl flipFitAdminDAOImpl=new FlipFitAdminDAOImpl();
        flipFitAdminDAOImpl.validateOwner(ownerId);
        return true;
    }
    public boolean deleteOwner(int ownerId){
        System.out.println("AdminUserBusiness.deleteOwner" + ownerId);
        FlipFitGymOwnerDAOImpl flipFitGymOwnerDAOImpl=new FlipFitGymOwnerDAOImpl();
        return flipFitGymOwnerDAOImpl.deleteOwner(ownerId);
    }


}
