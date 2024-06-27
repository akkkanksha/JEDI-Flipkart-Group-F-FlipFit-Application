package com.flipkart.bean;

public class FlipFitAdmin  {
    private int userId;
    private String password;

    void setUserID(int userId){
        this.userId=userId;
    }
    void setPassword(String password){
        this.password=password;
    }
    public int getUserID(){
        return this.userId;
    }
    public String getPassword() {
        return password;
    }
}
