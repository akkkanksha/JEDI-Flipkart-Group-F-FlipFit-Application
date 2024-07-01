package com.flipkart.dao.interfaces;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

public interface IFlipFitUserDAO {
    public FlipFitUser loginAsCustomer(String emailID, String password);
    public FlipFitUser loginAsOwner(String emailID, String password);

    public void addUser(FlipFitUser ffu);
    public void deleteUser(FlipFitUser ffu);
    public void changeUser(FlipFitUser ffu);
    public FlipFitUser getUser(int userID);
}
