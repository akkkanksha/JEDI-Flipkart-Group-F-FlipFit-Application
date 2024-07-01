package com.flipkart.bean;

public class FlipFitAdmin  {
    private int userID;
    private String password;

    void setUserID(int userId){
        this.userID =userId;
    }
    void setPassword(String password){
        this.password=password;
    }
    public int getUserID(){
        return this.userID;
    }
    public String getPassword() {
        return password;
    }
}
