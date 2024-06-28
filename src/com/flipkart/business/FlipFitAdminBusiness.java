package com.flipkart.business;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.interfaces.IFlipFitAdmin;
import com.flipkart.dao.FlipFitAdminDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminBusiness implements IFlipFitAdmin {
    private FlipFitAdmin FFAdmin;
    public FlipFitAdminBusiness(FlipFitAdmin FFAdmin){
        this.FFAdmin=FFAdmin;
    }

    public boolean adminLogin(FlipFitAdmin adminUser){
        FlipFitAdminDAOImpl flipFitAdminDAOImpl=new FlipFitAdminDAOImpl();
        System.out.println("AdminUserBusiness.adminLogin");
        flipFitAdminDAOImpl.adminLogin(adminUser);
        return true;
    }
    public List<FlipFitGymOwner> getPendingOwnerList(){
        System.out.println("AdminUserBusiness.getPendingOwnerList");
        FlipFitAdminDAOImpl flipFitAdminDAOImpl=new FlipFitAdminDAOImpl();
        return flipFitAdminDAOImpl.getPendingOwnerList();
    }
    public List<FlipFitGymOwner> getApprovedOwnerList(){
        System.out.println("AdminUserBusiness.getApprovedOwnerList");
        FlipFitAdminDAOImpl flipFitAdminDAOImpl=new FlipFitAdminDAOImpl();
        return flipFitAdminDAOImpl.getApprovedOwnerList();
    }
    public List<FlipFitGymCustomer> getUserList(){
        System.out.println("AdminUserBusiness.getUserList");
        FlipFitAdminDAOImpl flipFitAdminDAOImpl=new FlipFitAdminDAOImpl();
        return flipFitAdminDAOImpl.getUserList();
    }
    public boolean validateOwner(int ownerId){
        System.out.println("AdminUserBusiness.validateOwner "+ownerId);
        FlipFitAdminDAOImpl flipFitAdminDAOImpl=new FlipFitAdminDAOImpl();
        flipFitAdminDAOImpl.validateOwner(ownerId);
        return true;
    }
    public boolean deleteOwner(int ownerId){
        System.out.println("AdminUserBusiness.deleteOwner" + ownerId);
        FlipFitAdminDAOImpl flipFitAdminDAOImpl=new FlipFitAdminDAOImpl();
        flipFitAdminDAOImpl.deleteOwner(ownerId);
        return true;
    }
    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId){
        System.out.println("AdminUserBusiness.getGymCentreUsingOwnerId "+ownerId);
        FlipFitAdminDAOImpl flipFitAdminDAOImpl=new FlipFitAdminDAOImpl();
        return flipFitAdminDAOImpl.getGymCentreUsingOwnerId(ownerId);
    }

}
