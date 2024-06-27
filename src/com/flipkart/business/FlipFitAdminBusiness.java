package com.flipkart.business;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.business.interfaces.IFlipFitAdmin;

import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminBusiness implements IFlipFitAdmin {
    private FlipFitAdmin FFAdmin;
    public FlipFitAdminBusiness(FlipFitAdmin FFAdmin){
        this.FFAdmin=FFAdmin;
    }

    public boolean adminLogin(FlipFitAdmin adminUser){
        System.out.println("AdminUserBusiness.adminLogin");
        return true;
    }
    public List<Object> getPendingOwnerList(){
        System.out.println("AdminUserBusiness.getPendingOwnerList");
        return new ArrayList<Object>();
    }
    public List<Object> getUserList(){
        System.out.println("AdminUserBusiness.getUserList");
        return new ArrayList<Object>();
    }
    public boolean validateOwner(int ownerId){
        System.out.println("AdminUserBusiness.validateOwner "+ownerId);
        return true;
    }
    public boolean deleteOwner(int ownerId){
        System.out.println("AdminUserBusiness.deleteOwner" + ownerId);
        return true;
    }


}
