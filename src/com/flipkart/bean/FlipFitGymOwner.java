package com.flipkart.bean;

public class FlipFitGymOwner extends AbstractUser{
    public String panID;
    public String gstNum;
    public String aadharNumber;
    public boolean isApproved;

    public String getPanID() {
        return panID;
    }

    public void setPanID(String panID) {
        panID = panID;
    }

    public String getGSTNum() {
        return gstNum;
    }

    public void setGSTIN(String gstNum) {
        this.gstNum = gstNum;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        aadharNumber = aadharNumber;
    }

    public boolean getIsApproved() {
        return isApproved;
    }
    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
}
