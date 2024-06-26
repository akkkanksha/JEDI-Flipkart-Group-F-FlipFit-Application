package com.flipkart.business.interfaces;

import com.flipkart.bean.AdminUser;

import java.util.ArrayList;
import java.util.List;

public interface IAdminUser {
    public boolean adminLogin(AdminUser adminUser);
    public List<Object> getPendingOwnerList();
    public List<Object> getUserList();
    public boolean validateOwner(int ownerId);
    public boolean deleteOwner(int ownerId);
}
