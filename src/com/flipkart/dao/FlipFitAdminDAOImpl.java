package com.flipkart.dao;

import com.flipkart.bean.AdminUser;
import com.flipkart.dao.interfaces.IFlipFitAdminDAO;

import java.util.List;

public class FlipFitAdminDAOImpl implements IFlipFitAdminDAO {

    @Override
    public boolean adminLogin(AdminUser adminUser) {
        return false;
    }

    @Override
    public List<Object> getPendingOwnerList() {
        return List.of();
    }

    @Override
    public List<Object> getUserList() {
        return List.of();
    }

    @Override
    public boolean validateOwner(int ownerId) {
        return false;
    }

    @Override
    public boolean deleteOwner(int ownerId) {
        return false;
    }
}
