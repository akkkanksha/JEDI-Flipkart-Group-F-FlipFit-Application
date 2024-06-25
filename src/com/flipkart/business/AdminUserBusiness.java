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
        return true;
    }
    public List<Object> getPendingOwnerList(){

        return new ArrayList<Object>();
    }
    public List<Object> getUserList(){
        return new ArrayList<Object>();
    }
    public boolean validateOwner(){
        return true;
    }
    public boolean deleteOwner(){
        return true;
    }


}
