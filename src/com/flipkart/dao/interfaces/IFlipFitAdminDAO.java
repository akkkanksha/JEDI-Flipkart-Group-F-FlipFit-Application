package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitAdmin;

import java.util.List;

public interface IFlipFitAdminDAO {
    public boolean adminLogin(FlipFitAdmin adminUser);
    public List<FlipFitAdmin> getPendingOwnerList(int adminId);
    public List<Object> getUserList();
    public boolean validateOwner(int ownerId);
    public boolean deleteOwner(int ownerId);
}
