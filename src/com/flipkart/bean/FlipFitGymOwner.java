package com.flipkart.bean;

public class FlipFitGymOwner extends AbstractUser{
    public String PAN;
    public String GSTIN;
    public String aadharNumber;
    public boolean isApproved;

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        PAN = PAN;
    }

    public String getGSTIN() {
        return GSTIN;
    }

    public void setGSTIN(String gstNum) {
        this.GSTIN = gstNum;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        aadharNumber = aadharNumber;
    }

    public boolean isApproved() {
        return isApproved;
    }
    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
}
