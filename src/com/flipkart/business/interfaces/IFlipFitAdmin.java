package com.flipkart.business.interfaces;

import com.flipkart.bean.FlipFitAdmin;

import java.util.List;

public interface IFlipFitAdmin {
    public boolean adminLogin(FlipFitAdmin admin);
    public List<Object> getPendingOwnerList(String adminId);
    public List<Object> getUserList();
    public boolean validateOwner(int ownerId);
    public boolean deleteOwner(int ownerId);
}
