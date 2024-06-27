package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface IFlipFitAdminDAO {
    public FlipFitAdmin adminLogin(String email, String password);
    public List<FlipFitGymOwner> getPendingOwnerList(int adminId);
    public List<FlipFitGymCustomer> getUserList();
    public boolean validateOwner(int ownerId);
    public boolean deleteOwner(int ownerId);
}
