package com.flipkart.business;

import com.flipkart.bean.AdminUser;

import java.util.ArrayList;
import java.util.List;

public class AdminUserBusiness {
    private AdminUser adminUser;
    public AdminUserBusiness(AdminUser adminUser){
        this.adminUser=adminUser;
    }
    public boolean adminLogin(AdminUser adminUser){
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
