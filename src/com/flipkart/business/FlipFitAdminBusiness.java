package com.flipkart.business;
import com.flipkart.dao.interfaces.IFlipFitAdminDAO;
import com.flipkart.bean.*;
import com.flipkart.business.interfaces.IFlipFitAdmin;
import com.flipkart.dao.FlipFitAdminDAOImpl;

import java.util.List;

public class FlipFitAdminBusiness implements IFlipFitAdmin {
    private final IFlipFitAdminDAO flipFitAdminDAOImpl ;
    public FlipFitAdminBusiness(FlipFitAdminDAOImpl FFAdmin){
        this.flipFitAdminDAOImpl=FFAdmin;
    }

    public boolean adminLogin(FlipFitAdmin flipFitAdmin){
        System.out.println("AdminUserBusiness.adminLogin");
        return flipFitAdminDAOImpl.adminLogin(flipFitAdmin);
    }
    public List<FlipFitGymOwner> getPendingOwnerList(){
        System.out.println("AdminUserBusiness.getPendingOwnerList");
        return flipFitAdminDAOImpl.getPendingOwnerList();
    }
    public List<FlipFitGymOwner> getApprovedOwnerList(){
        System.out.println("AdminUserBusiness.getApprovedOwnerList");
        return flipFitAdminDAOImpl.getApprovedOwnerList();
    }
    public List<FlipFitGymCustomer> getUserList(){
        System.out.println("AdminUserBusiness.getUserList");
        return flipFitAdminDAOImpl.getUserList();
    }
    public boolean validateOwner(int ownerId){
        return flipFitAdminDAOImpl.validateOwner(ownerId);
    }
    public boolean deleteOwner(int ownerId){
        System.out.println("AdminUserBusiness.deleteOwner" + ownerId);
        flipFitAdminDAOImpl.deleteOwner(ownerId);
        return true;
    }
    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId){
        System.out.println("AdminUserBusiness.getGymCentreUsingOwnerId "+ownerId);
        return flipFitAdminDAOImpl.getGymCentreUsingOwnerId(ownerId);
    }

}
