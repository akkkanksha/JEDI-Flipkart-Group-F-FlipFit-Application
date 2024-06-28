package com.flipkart.bean;

public class FlipFitGymOwner extends AbstractUser{
    public String panId;
    public String gstNum;
    public String aadharNumber;
    public boolean isApproved;

    public String getPanId() {
        return panId;
    }

    public void setPanId(String panId) {
        panId = panId;
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
        this.aadharNumber = aadharNumber;
    }

    public boolean getIsApproved() {
        return isApproved;
    }
    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
}
