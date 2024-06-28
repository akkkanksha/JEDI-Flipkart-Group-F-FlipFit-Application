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
        FlipFitGymOwnerDAOImpl flipFitGymOwnerDAOImpl=new FlipFitGymOwnerDAOImpl();
        return flipFitGymOwnerDAOImpl.getPendingOwnerList();
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
