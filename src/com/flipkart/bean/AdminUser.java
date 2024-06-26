package com.flipkart.bean;

import com.flipkart.business.interfaces.IAdminUser;

public class AdminUser  {
    private String userId;
    private String password;

    void setUserID(String userId){
        this.userId=userId;
    }
    void setPassword(String password){
        this.password=password;
    }
    public String getUserID(){
        return this.userId;
    }
    public String getPassword() {
        return password;
    }
}
