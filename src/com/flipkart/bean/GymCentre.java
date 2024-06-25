package com.flipkart.bean;

public class GymCentre extends AbstractUser{
    private String PAN;
    private String Aadhaar;

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getAadhaar() {
        return Aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        Aadhaar = aadhaar;
    }

    public String getGSTIN() {
        return GSTIN;
    }

    public void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }

    private String GSTIN;

}
