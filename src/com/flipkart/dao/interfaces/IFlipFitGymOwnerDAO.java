package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymOwner;

public interface IFlipFitGymOwnerDAO {

    public FlipFitGymOwner getOwnerDetails(String emailId);
    public FlipFitGymOwner createOwner(String panId, String gstNum, String aadharNumber, String userName, String password, String emailID, String phoneNumber, String city, String pinCode, int role);
    public void viewPayments();
}
