package com.flipkart.dao;

import com.flipkart.bean.AdminUser;

import java.util.List;

public interface IFlipFitAdminDAO {
    public boolean adminLogin(AdminUser adminUser);
    public List<Object> getPendingOwnerList();
    public List<Object> getUserList();
    public boolean validateOwner(int ownerId);
    public boolean deleteOwner(int ownerId);
}
